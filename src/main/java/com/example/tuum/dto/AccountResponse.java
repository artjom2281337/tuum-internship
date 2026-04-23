package com.example.tuum.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.tuum.model.Account;


public class AccountResponse {
    private Long account_id;
    private Long customer_id;
    private List<BalanceResponse> balance;

    public AccountResponse() {}
    
    public static AccountResponse fromAccount(Account account) {
        AccountResponse response = new AccountResponse();
        response.setAccount_id(account.getId());
        response.setCustomer_id(account.getCustomer_id());
        if (account.getBalances() != null) {
            response.setBalance(account.getBalances().stream().map(BalanceResponse::fromBalance).collect(Collectors.toList()));
        }
        return response;
    }
    
    public Long getAccount_id() {
        return account_id;
    }
    public Long getCustomer_id() {
        return customer_id;
    }
    public List<BalanceResponse> getBalance() {
        return balance;
    }
    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    public void setBalance(List<BalanceResponse> balance) {
        this.balance = balance;
    }
}
