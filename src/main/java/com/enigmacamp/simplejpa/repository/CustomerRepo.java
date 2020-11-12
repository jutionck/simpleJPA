package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {

    @Query("SELECT c FROM Customer c where c.firstName LIKE :firstName%")
    List<Customer> findCustomerFirstNameStartWith(@Param("firstName") String firstName);

    Page<Customer> findAll(Pageable pageable);
}
