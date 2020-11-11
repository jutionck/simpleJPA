package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepo extends JpaRepository<UserAccount, String> {
}
