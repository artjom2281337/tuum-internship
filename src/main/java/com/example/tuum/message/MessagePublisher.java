package com.example.tuum.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.tuum.config.RabbitConfig;
import com.example.tuum.model.Account;
import com.example.tuum.model.Transaction;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessagePublisher {
 
    private static final Logger logger = LoggerFactory.getLogger(MessagePublisher.class);
    private final RabbitTemplate rabbitTemplate;

    public record AccountEvent(String eventType, Long accountId, Long customerId, String country) {}
    public record TransactionEvent(String eventType, Long transactionId, Long accountId, BigDecimal amount, String currency, String direction, String description) {}
    public record BalanceEvent(String eventType, Long accountId, String currency, BigDecimal newBalance) {}

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishAccountCreated(Account account) {
        AccountEvent event = new AccountEvent("ACCOUNT_CREATED", account.getId(), account.getCustomerId(), account.getCountry());
        logger.info("Publishing AccountCreated event, accountId= {}", account.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.ACCOUNT_QUEUE, event);
    }

    public void publishBalanceUpdated(Long accountId, String currency, BigDecimal newBalance) {
        BalanceEvent event = new BalanceEvent("BALANCE_UPDATED", accountId, currency, newBalance);
        logger.info("Publishing BalanceUpdated event, accountId= {} currency= {}", accountId, currency);
        rabbitTemplate.convertAndSend(RabbitConfig.ACCOUNT_QUEUE, event);
    }

    public void publishTransactionCreated(Transaction transaction) {
        TransactionEvent event = new TransactionEvent("TRANSACTION_CREATED", transaction.getId(),transaction.getAccountId(),transaction.getAmount(),transaction.getCurrency(),transaction.getDirection().name(),transaction.getDescription());
        logger.info("Publishing TransactionCreated, transactionId = {}", transaction.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.TRANSACTION_QUEUE, event);
    }   
}
