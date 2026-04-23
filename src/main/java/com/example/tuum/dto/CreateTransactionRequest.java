package com.example.tuum.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateTransactionRequest {
    @NotNull(message = "accountId required")
    private Long accountId;

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
    public CreateTransactionRequest(Long accountId, BigDecimal amount, String currency, String direction, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.direction = direction;
        this.description = description;
    }
    
    public Long getAccountId() {
        return accountId;
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
    public void setAccount_id(Long accountId) {
        this.accountId = accountId;
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
