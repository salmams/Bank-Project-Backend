package com.project.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.bank.entity.Branch;
import com.project.bank.repository.BranchRepository;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }
    
    public List<Branch> getBranches(){
        return branchRepository.findAll();
    }

    public Branch getBranchById(String ifsccode){
        return branchRepository.findById(ifsccode).orElse(null);
    }
}
