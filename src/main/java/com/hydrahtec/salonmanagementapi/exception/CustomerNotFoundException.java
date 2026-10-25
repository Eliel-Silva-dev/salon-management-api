package com.hydrahtec.salonmanagementapi.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Custumer not found with id: " + id);
    }

    boolean existsByPhoneNumber(String phoneNumber) {
        return false;
    }
}
