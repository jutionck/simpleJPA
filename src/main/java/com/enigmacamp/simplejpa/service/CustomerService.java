package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer registration(Customer customer);

    Customer activation(String customerId);

    Customer unregistration(String customerId);

    List<Customer> getAllCustomer();

    void printList(List<Customer> customers);
}