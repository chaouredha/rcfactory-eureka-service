package org.rcfactory.billingservice.api;

import java.util.Optional;

import org.rcfactory.billingservice.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceApi {

    @GetMapping("/api/v1/customers/{id}")
    Optional<Customer> customer(@PathVariable Long id);

    @GetMapping("/api/v1/customers")
    Customer customers();
}
