package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, String>{
    
}
