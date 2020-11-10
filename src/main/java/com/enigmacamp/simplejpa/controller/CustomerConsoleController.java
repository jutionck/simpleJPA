package com.enigmacamp.simplejpa.controller;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerConsoleController implements CommandLineRunner {
    CustomerService customerService;

    CustomerConsoleController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {

        //Insert Data to table m_customer
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Jution");
        newCustomer.setLastName("Kirana");
        customerService.registration(newCustomer);
        //Get All Data
        List<Customer> customers = customerService.getAllCustomer();
        customerService.printList(customers);

    }
}
