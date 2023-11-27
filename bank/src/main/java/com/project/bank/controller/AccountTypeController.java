package com.project.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.entity.AccountType;
import com.project.bank.service.AccountTypeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountTypeController {
    private final AccountTypeService accountTypeService;

    public AccountTypeController(AccountTypeService accountTypeService){
        this.accountTypeService=accountTypeService;
    }

    @GetMapping("/accounttypes")
    public List<AccountType> findAllAccountTypes(){
        return accountTypeService.getAccountTypes();
    }

    @GetMapping("/accounttype/{id}")
    public AccountType findAccountTypeById(@PathVariable int id){
        return accountTypeService.getAccountTypeById(id);
    }
}
