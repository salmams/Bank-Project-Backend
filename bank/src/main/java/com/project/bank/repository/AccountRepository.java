package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
