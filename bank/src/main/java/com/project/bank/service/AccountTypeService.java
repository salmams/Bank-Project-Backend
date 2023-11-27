package com.project.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.bank.entity.AccountType;
import com.project.bank.repository.AccountTypeRepository;

@Service
public class AccountTypeService {
    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeService(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountType> getAccountTypes(){
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountTypeById(int acctype_id){
        return accountTypeRepository.findById(acctype_id).orElse(null);
    }
}
