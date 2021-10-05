package org.rcfactory.billingservice.controllers.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private Long clientId;
}
