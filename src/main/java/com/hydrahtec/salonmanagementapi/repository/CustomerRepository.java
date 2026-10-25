package com.hydrahtec.salonmanagementapi.repository;


import com.hydrahtec.salonmanagementapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
