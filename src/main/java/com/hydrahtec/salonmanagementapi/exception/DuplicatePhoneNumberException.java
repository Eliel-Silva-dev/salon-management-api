package com.hydrahtec.salonmanagementapi.exception;

public class DuplicatePhoneNumberException extends RuntimeException{
    public DuplicatePhoneNumberException() {
        super("A customer with this phone number already exists");
    }
}
