package com.hydrahtec.salon_management_api.dto;

import com.hydrahtec.salon_management_api.entity.Customer;

public record CustomerResponse(
        Long id, String name, String phoneNumber
) {
    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getPhoneNumber());
    }
}
