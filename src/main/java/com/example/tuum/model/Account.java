package com.example.tuum.model;

import java.util.List;

public class Account {
    private Long id;
    private Long customerId;
    private String country;
    private List<Balance> balances;

    public Account() {}
    public Account(Long customerId, String country) {
        this.customerId = customerId;
        this.country = country;
    }

    public Long getId() {
        return id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public String getCountry() {
        return country;
    }
    public List<Balance> getBalances() {
        return balances;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setBalance(List<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", customerId=" + customerId + ", country='" + country + '\'' + ", balances=" + balances + '}';
    }
}
