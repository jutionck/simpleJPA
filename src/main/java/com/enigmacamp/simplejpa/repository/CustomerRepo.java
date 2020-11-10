package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
