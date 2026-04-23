package com.example.tuum.model;

import java.math.BigDecimal;

public class Balance {
    private Long id;
    private Long accountId;
    private BigDecimal availabeAmount;
    private String currency;

    public Balance() {}
    public Balance(Long accountId, BigDecimal availableAmount, String currency) {
        this.accountId = accountId;
        this.availabeAmount = availableAmount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }
    public Long getAccountId() {
        return accountId;
    }
    public BigDecimal getAvailabeAmount() {
        return availabeAmount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setAvailabeAmount(BigDecimal availabeAmount) {
        this.availabeAmount = availabeAmount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Balance{" + "id=" + id + ", accountId=" + accountId + ", availableAmount=" + availabeAmount + ", currency='" + currency +'\'' + '}';
    }
}
