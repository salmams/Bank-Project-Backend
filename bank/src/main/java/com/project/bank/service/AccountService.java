package com.project.bank.service;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bank.entity.Account;
import com.project.bank.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccountByAccNumber(long accNumber){
        return accountRepository.findById(accNumber).orElse(null);
    }
}
