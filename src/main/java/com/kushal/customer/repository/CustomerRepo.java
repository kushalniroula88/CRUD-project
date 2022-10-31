package com.kushal.customer.repository;

import com.kushal.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

        List<Customer>findByNameStartingWith(String name);
}
