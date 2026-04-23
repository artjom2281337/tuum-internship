package com.example.tuum.dto;

import java.math.BigDecimal;

import com.example.tuum.model.Transaction;

public class TransactionResponse {
    private Long accountId;
    private Long transactionId;
    private BigDecimal amount;
    private String currency;
    private String direction;
    private String description;
    private BigDecimal balanceAfterTransaction;

    public Long getAccountId() {
        return accountId;
    }
    public Long getTransactionId() {
        return transactionId;
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
    public BigDecimal getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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
    public void setBalanceAfterTransaction(BigDecimal balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }



    public TransactionResponse() {}
    public static TransactionResponse fromTransaction(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setAccountId(transaction.getAccountId());
        response.setTransactionId(transaction.getId());
        response.setAmount(transaction.getAmount());
        response.setCurrency(transaction.getCurrency());
        response.setDirection(transaction.getDirection().name());
        response.setDescription(transaction.getDescription());
        response.setBalanceAfterTransaction(transaction.getBalanceAfterTransaction());
        return response;
    }
}
