package com.kushal.customer.controller;

import com.kushal.customer.model.Customer;
import com.kushal.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void>createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteByCustomerId")
    public ResponseEntity<Void>deleteByCustomerId(@RequestParam Long id){
        customerService.deleteByCustomerId(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
//    @GetMapping("/{name}")
//    public ResponseEntity<>getByCustomerName(@PathVariable("name") String name){
//        return customerService.getByCustomerName(name);
//        return new ResponseEntity<>(HttpStatus.FOUND);
//    }
    @GetMapping
    private List<Customer>getAllCustomers(){
        return customerService.getAllCustomers();
       // return new ResponseEntity<Customer>(HttpStatus.FOUND);
    }
    @GetMapping("/customerId")
    private Customer getByCustomerId(@RequestParam Long id){
        return customerService.getByCustomerId(id);
    }
    @GetMapping("/customerName")
    private List<Customer> getByCustomerName(@RequestParam String firstLetter){
        return customerService.getByCustomerName(firstLetter);
    }
}
