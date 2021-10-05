package org.rcfactory.billingservice.controllers.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.rcfactory.billingservice.domain.Customer;

import lombok.Data;

@Data
public class InvoiceResponseDTO {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private Customer customer;
}
