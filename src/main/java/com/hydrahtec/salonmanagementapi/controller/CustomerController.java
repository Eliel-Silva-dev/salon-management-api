package com.hydrahtec.salonmanagementapi.controller;

import com.hydrahtec.salonmanagementapi.dto.CreateCustomerRequest;
import com.hydrahtec.salonmanagementapi.dto.CustomerResponse;
import com.hydrahtec.salonmanagementapi.entity.Customer;
import com.hydrahtec.salonmanagementapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService CUSTOMERSERVICE;

    public CustomerController(CustomerService customerService) {
        this.CUSTOMERSERVICE = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CreateCustomerRequest request) {
        Customer created = CUSTOMERSERVICE.create(request.name(), request.phoneNumber());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(CustomerResponse.from(created));
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id) {
        return CustomerResponse.from(CUSTOMERSERVICE.findById(id));
    }

    @GetMapping
    public PagedModel<CustomerResponse> findAll(
            @PageableDefault(size = 20, sort = {"name", "id"}) Pageable pageable
    ) {
        return new PagedModel<>(CUSTOMERSERVICE.findAll(pageable).map(CustomerResponse::from));
    }

}
