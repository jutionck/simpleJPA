package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerName;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {


    Customer registration(CustomerRegistration customerRegistration);
    //Insert data to table m_customer
    //Customer registration(Customer customer);

    Customer activation(String customerId);

    Customer unregistration(String customerId);

    //Dipakai jika tidak pakai pagination
    //List<Customer> getAllCustomer();

    //Pagination
    //List<Customer> getAllCustomer(int page, int size);
    Page<Customer> getAllCustomer(int page, int size, String[] sort);

    void printList(List<Customer> customers);

    List<Customer> getCustomerByName(CustomerName containingBy, String name);
}
