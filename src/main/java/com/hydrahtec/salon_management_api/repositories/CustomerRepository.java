package com.hydrahtec.salon_management_api.repositories;


import com.hydrahtec.salon_management_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
