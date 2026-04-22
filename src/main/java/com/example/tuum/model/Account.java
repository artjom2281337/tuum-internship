package com.example.tuum.model;

import java.util.List;

public class Account {
    private Long id;
    private Long customer_id;
    private String country;
    private List<Balance> balance;

    public Account() {}
    public Account(Long customer_id, String country) {
        this.customer_id = customer_id;
        this.country = country;
    }

    public Long getId() {
        return id;
    }
    public Long getCustomer_id() {
        return customer_id;
    }
    public String getCountry() {
        return country;
    }
    public List<Balance> getBalance() {
        return balance;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setBalance(List<Balance> balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", customer_id=" + customer_id + ", country='" + country + '\'' + ", balance=" + balance + '}';
    }
}
