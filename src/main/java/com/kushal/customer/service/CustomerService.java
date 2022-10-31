package com.kushal.customer.service;

import com.kushal.customer.model.Customer;
import com.kushal.customer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    public final CustomerRepo customerRepo;

    public void save(Customer customer){
        customerRepo.save(customer);
    }

    public void deleteByCustomerId(Long customerId){
        customerRepo.deleteById(customerId);
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        customers.addAll(customerRepo.findAll());
        return customers;
    }
    public Customer getByCustomerId(Long id) {
        return customerRepo.findById(id).get();
    }
    public List<Customer> getByCustomerName(String name) {
        return customerRepo.findByNameStartingWith(name);
    }
}
