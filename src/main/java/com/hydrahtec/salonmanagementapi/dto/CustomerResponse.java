package com.hydrahtec.salonmanagementapi.dto;

import com.hydrahtec.salonmanagementapi.entity.Customer;

public record CustomerResponse(
        Long id, String name, String phoneNumber
) {
    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getPhoneNumber());
    }
}
