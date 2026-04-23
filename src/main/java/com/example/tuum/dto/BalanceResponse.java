package com.example.tuum.dto;

import java.math.BigDecimal;

import com.example.tuum.model.Balance;

public class BalanceResponse {
    private BigDecimal availabeAmount;
    private String currency;

    public BalanceResponse() {}
    public BalanceResponse(BigDecimal availableAmount, String currency) {
        this.availabeAmount = availableAmount;
        this.currency = currency;
    }

    public static BalanceResponse fromBalance(Balance balance) {
        return new BalanceResponse(balance.getAvailabeAmount(), balance.getCurrency());
    }

    public BigDecimal getAvailabeAmount() {
        return availabeAmount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setAvailabe_amount(BigDecimal availabeAmount) {
        this.availabeAmount = availabeAmount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
