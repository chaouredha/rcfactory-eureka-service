package org.rcfactory.billingservice.mappers;

import org.mapstruct.Mapper;
import org.rcfactory.billingservice.controllers.dto.InvoiceRequestDTO;
import org.rcfactory.billingservice.controllers.dto.InvoiceResponseDTO;
import org.rcfactory.billingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice ivoiceRequestToInvoice(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO ivoiceToInvoiceResponseDto(Invoice invoice);
}
