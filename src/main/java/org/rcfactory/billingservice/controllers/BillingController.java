package org.rcfactory.billingservice.controllers;

import java.util.List;

import org.rcfactory.billingservice.controllers.dto.InvoiceRequestDTO;
import org.rcfactory.billingservice.controllers.dto.InvoiceResponseDTO;
import org.rcfactory.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/billings")
public class BillingController {
    private final InvoiceService invoiceService;

    public BillingController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceResponseDTO> invoices() {
        return invoiceService.invoices();
    }

    @GetMapping("/{id}")
    public InvoiceResponseDTO invoice(@PathVariable Long id) {
        return invoiceService.invoice(id);
    }

    @PostMapping
    public InvoiceResponseDTO invoice(@RequestBody InvoiceRequestDTO invoiceRequest) {
        return invoiceService.save(invoiceRequest);
    }
}
