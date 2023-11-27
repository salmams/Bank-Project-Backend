package com.project.bank.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class AccountType {
    @Id
    @GeneratedValue
    private int acctype_id;
    private String account_type;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts; 
    
    public int getAcctype_id() {
        return acctype_id;
    }
    public void setAcctype_id(int acctype_id) {
        this.acctype_id = acctype_id;
    }
    public String getAccount_type() {
        return account_type;
    }
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    public AccountType() {
    }
    public AccountType(int acctype_id, String account_type) {
        this.acctype_id = acctype_id;
        this.account_type = account_type;
    }
    @Override
    public String toString() {
        return "AccountType [acctype_id=" + acctype_id + ", account_type=" + account_type + "]";
    }
    
    

}
