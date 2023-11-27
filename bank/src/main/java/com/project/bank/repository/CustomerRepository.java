package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Customer findByPhone(String phone);

    
}
