package com.project.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.entity.Branch;
import com.project.bank.service.BranchService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService){
        this.branchService = branchService;
    }

    @GetMapping("/branches")
    public List<Branch> findAllBranch(){
        return branchService.getBranches();
    }

    @GetMapping("/branch/{id}")
    public Branch findBranchById(@PathVariable String id){
        return branchService.getBranchById(id);
    }
}
