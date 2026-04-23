package com.example.tuum.model;

import java.math.BigDecimal;


public class Transaction {
    private Long id;
    private Long account_id;
    private BigDecimal amount;
    private String currency;
    private TransactionDirection direction;
    private String description;
    private BigDecimal balance_after_transaction;

    public Transaction() {}
    public Transaction(Long account_id, BigDecimal amount, String currency, TransactionDirection direction, String description) {
        this.account_id = account_id;
        this.amount = amount;
        this.currency = currency;
        this.direction = direction;
        this.description = description;
    }

    public Long getId() {
        return id;
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
    public TransactionDirection getDirection() {
        return direction;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getBalance_after_transaction() {
        return balance_after_transaction;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setDirection(TransactionDirection direction) {
        this.direction = direction;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setBalance_after_transaction(BigDecimal balance_after_transaction) {
        this.balance_after_transaction = balance_after_transaction;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", account_id=" + account_id + ", amount=" + amount + ", currency='" + currency + '\'' + ", direction=" + direction + ", description='" + description + '\'' + ", balance_after_transaction=" + balance_after_transaction + '}';
    }
}
