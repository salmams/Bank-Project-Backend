package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.entity.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{
    
}
