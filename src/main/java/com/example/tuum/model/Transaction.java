package com.example.tuum.model;

import java.math.BigDecimal;


public class Transaction {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private String currency;
    private TransactionDirection direction;
    private String description;
    private BigDecimal balanceAfterTransaction;

    public Transaction() {}
    public Transaction(Long accountId, BigDecimal amount, String currency, TransactionDirection direction, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.direction = direction;
        this.description = description;
    }

    public Long getId() {
        return id;
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
    public TransactionDirection getDirection() {
        return direction;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setDirection(TransactionDirection direction) {
        this.direction = direction;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setBalanceAfterTransaction(BigDecimal balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", accountId=" + accountId + ", amount=" + amount + ", currency='" + currency + '\'' + ", direction=" + direction + ", description='" + description + '\'' + ", balanceAfterTransaction=" + balanceAfterTransaction + '}';
    }
}
