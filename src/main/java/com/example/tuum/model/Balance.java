package com.example.tuum.model;

import java.math.BigDecimal;

public class Balance {
    private Long id;
    private Long account_id;
    private BigDecimal availabe_amount;
    private String currency;

    public Balance() {}
    public Balance(Long account_id, BigDecimal available_amount, String currency) {
        this.account_id = account_id;
        this.availabe_amount = available_amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }
    public Long getAccount_Id() {
        return account_id;
    }
    public BigDecimal getAvailabe_amount() {
        return availabe_amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAccount_Id(Long account_id) {
        this.account_id = account_id;
    }
    public void setAvailabe_amount(BigDecimal availabe_amount) {
        this.availabe_amount = availabe_amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Balance{" + "id=" + id + ", account_id=" + account_id + ", available_amount=" + availabe_amount + ", currency='" + currency +'\'' + '}';
    }
}
