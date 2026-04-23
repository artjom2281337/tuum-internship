package com.example.tuum.dto;

import java.math.BigDecimal;

import com.example.tuum.model.Transaction;

public class TransactionResponse {
    private Long account_id;
    private Long transaction_id;
    private BigDecimal amount;
    private String currency;
    private String direction;
    private String description;
    private BigDecimal balance_after_transaction;

    public Long getAccount_id() {
        return account_id;
    }
    public Long getTransaction_id() {
        return transaction_id;
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
    public BigDecimal getBalance_after_transaction() {
        return balance_after_transaction;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
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
    public void setBalance_after_transaction(BigDecimal balance_after_transaction) {
        this.balance_after_transaction = balance_after_transaction;
    }



    public TransactionResponse() {}
    public static TransactionResponse fromTransaction(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setAccount_id(transaction.getAccount_id());
        response.setTransaction_id(transaction.getId());
        response.setAmount(transaction.getAmount());
        response.setCurrency(transaction.getCurrency());
        response.setDirection(transaction.getDirection().name());
        response.setDescription(transaction.getDescription());
        response.setBalance_after_transaction(transaction.getBalance_after_transaction());
        return response;
    }
}
