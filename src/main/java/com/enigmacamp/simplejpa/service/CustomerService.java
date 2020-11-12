package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import com.enigmacamp.simplejpa.repository.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    Customer registration(CustomerRegistration customerRegistration);

    Customer activation(String customerId);

    Customer unregistration(String customerId);

    Page<Customer> getAllCustomer(int page, int size, String[] sort);

    void printList(List<Customer> customers);

    List<Customer> findCustomer(SearchCriteria searchCriteria);

    List<Customer> findCustomer(List<SearchCriteria> searchCriteria);
}
