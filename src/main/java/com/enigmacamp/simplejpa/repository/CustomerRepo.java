package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    List<Customer> findByFirstNameContaining(String name);

    List<Customer> findByLastNameContaining(String name);

    @Query("SELECT c FROM Customer c where c.firstName LIKE :firstName%")
    List<Customer> findCustomerFirstNameStartWith(@Param("firstName") String firstName);
}
