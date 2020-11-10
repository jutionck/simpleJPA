package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerName;
import com.enigmacamp.simplejpa.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImplementation.class);

    CustomerRepo customerRepo;

    //Automatically autowired if there is only 1 constructor, @autowired is not needed
    CustomerServiceImplementation(CustomerRepo customerRepo) {
        Objects.requireNonNull(customerRepo);
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer registration(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer activation(String customerId) {
        return null;
    }

    @Override
    public Customer unregistration(String customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void printList(List<Customer> customers) {
        customers.forEach(customer -> log.debug(customer.toString()));
    }

    @Override
    public List<Customer> getCustomerByName(CustomerName containingBy, String name) {
        List<Customer> customers = new ArrayList<>();
        switch (containingBy) {
            case FIRSTNAME_CONTAINING:
                customers = customerRepo.findByFirstNameContaining(name);
                break;
            case LASTNAME_CONTAINING:
                customers = customerRepo.findByLastNameContaining(name);
                break;
            case FIRSTNAME_STARTING:
                customers = customerRepo.findCustomerFirstNameStartWith(name);
                break;
        }
        return customers;
    }


}
