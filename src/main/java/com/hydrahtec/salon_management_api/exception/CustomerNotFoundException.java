package com.hydrahtec.salon_management_api.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Custumer not found with id: " + id);
    }

    boolean existsByPhoneNumber(String phoneNumber) {
        return false;
    }
}
