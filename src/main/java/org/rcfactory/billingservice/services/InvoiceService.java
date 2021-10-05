package org.rcfactory.billingservice.services;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.rcfactory.billingservice.api.CustomerServiceApi;
import org.rcfactory.billingservice.controllers.dto.InvoiceRequestDTO;
import org.rcfactory.billingservice.controllers.dto.InvoiceResponseDTO;
import org.rcfactory.billingservice.entities.Invoice;
import org.rcfactory.billingservice.mappers.InvoiceMapper;
import org.rcfactory.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerServiceApi customerServiceApi;

    public InvoiceService(InvoiceRepository invoiceRepository,
            InvoiceMapper invoiceMapper,
            CustomerServiceApi customerServiceApi) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerServiceApi = customerServiceApi;
    }

    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        return ofNullable(invoiceRequestDTO)
                .map(invoiceMapper::ivoiceRequestToInvoice)
                .map(invoiceRepository::save)
                .map(invoiceMapper::ivoiceToInvoiceResponseDto)
                .orElse(null);
    }

    public List<InvoiceResponseDTO> invoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::ivoiceToInvoiceResponseDto)
                .collect(toList());
    }

    public InvoiceResponseDTO invoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElse(null);
        return customerServiceApi.customer(invoice.getClientId())
                .map(customer -> new Invoice(invoice.getId(),
                        invoice.getDate(),
                        invoice.getAmount(),
                        invoice.getClientId(),
                        customer))
                .map(invoiceMapper::ivoiceToInvoiceResponseDto)
                .orElse(null);
    }
}
