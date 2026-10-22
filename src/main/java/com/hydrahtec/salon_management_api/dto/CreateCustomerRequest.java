package com.hydrahtec.salon_management_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCustomerRequest(

        @NotBlank(message = "name is required")
        @Size(max = 255, message = "name must have at most 255 characters")
        String name,

        @NotBlank(message = "phone number is required")
        @Pattern(regexp = "^\\d{10,13}$", message = "phone number must contain 10 to 13 digits only")
        String phoneNumber
) {
}
