package com.example.tuum.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateTransactionRequest {
    @NotNull(message = "account_id required")
    private Long account_id;

    @NotNull(message = "amount required")
    @Positive(message = "amount must be positive")
    private BigDecimal amount;

    @NotBlank(message = "currency required")
    private String currency;

    @NotBlank(message = "direction required")
    private String direction;

    @NotBlank(message = "description required")
    private String description;

    public CreateTransactionRequest() {} 
    public CreateTransactionRequest(Long account_id, BigDecimal amount, String currency, String direction, String description) {
        this.account_id = account_id;
        this.amount = amount;
        this.currency = currency;
        this.direction = direction;
        this.description = description;
    }
    
    public Long getAccount_id() {
        return account_id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    public String getDirection() {
        return direction;
    }
    public String getDescription() {
        return description;
    }
    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
