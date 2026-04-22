package com.example.tuum.dto;

import java.math.BigDecimal;

import com.example.tuum.model.Balance;

public class BalanceResponse {
    private BigDecimal availabe_amount;
    private String currency;

    public BalanceResponse() {}
    public BalanceResponse(BigDecimal available_amount, String currency) {
        this.availabe_amount = available_amount;
        this.currency = currency;
    }

    public static BalanceResponse fromBalance(Balance balance) {
        return new BalanceResponse(balance.getAvailabe_amount(), balance.getCurrency());
    }

    public BigDecimal getAvailabe_amount() {
        return availabe_amount;
    }
    public String getCurrency() {
        return currency;
    }
    public void setAvailabe_amount(BigDecimal availabe_amount) {
        this.availabe_amount = availabe_amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
