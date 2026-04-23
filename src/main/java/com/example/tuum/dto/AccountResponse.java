package com.example.tuum.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.tuum.model.Account;


public class AccountResponse {
    private Long accountId;
    private Long customerId;
    private List<BalanceResponse> balances;

    public AccountResponse() {}
    
    public static AccountResponse fromAccount(Account account) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(account.getId());
        response.setCustomerId(account.getCustomerId());
        if (account.getBalances() != null) {
            response.setBalances(account.getBalances().stream().map(BalanceResponse::fromBalance).collect(Collectors.toList()));
        }
        return response;
    }
    
    public Long getAccountId() {
        return accountId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public List<BalanceResponse> getBalances() {
        return balances;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public void setBalances(List<BalanceResponse> balances) {
        this.balances = balances;
    }
}
