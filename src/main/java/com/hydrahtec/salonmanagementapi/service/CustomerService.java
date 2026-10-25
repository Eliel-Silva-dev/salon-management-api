package com.hydrahtec.salonmanagementapi.service;

import com.hydrahtec.salonmanagementapi.entity.Customer;
import com.hydrahtec.salonmanagementapi.exception.CustomerNotFoundException;
import com.hydrahtec.salonmanagementapi.exception.DuplicatePhoneNumberException;
import com.hydrahtec.salonmanagementapi.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private static final Logger log = LogManager.getLogger(CustomerService.class);

    private final CustomerRepository CUSTOMERREPOSITORY;

    public CustomerService(CustomerRepository customerRepository) {
        this.CUSTOMERREPOSITORY = customerRepository;
    }

    @Transactional
    public Customer create(String name, String phoneNumber) {
        if (CUSTOMERREPOSITORY.existsByPhoneNumber(phoneNumber)) {
            throw new DuplicatePhoneNumberException();
        }

        Customer saved = CUSTOMERREPOSITORY.save(new Customer(name, phoneNumber));
        log.info("Customer create with id {}", saved.getId());
        return saved;
    }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        return CUSTOMERREPOSITORY.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return CUSTOMERREPOSITORY.findAll();
    }
}
