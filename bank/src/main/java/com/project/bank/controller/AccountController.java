package com.project.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.entity.Account;
import com.project.bank.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        try {
            accountService.saveAccount(account);
            return new ResponseEntity<>("Account created successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/account/{id}")
    public Account findAccountById(@PathVariable long id){
        return accountService.getAccountByAccNumber(id);
    }
}
