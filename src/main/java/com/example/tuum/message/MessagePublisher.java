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

    public record AccountEvent(String eventType, Long account_id, Long customer_id, String country) {}
    public record TransactionEvent(String eventType, Long transaction_id, Long account_id, BigDecimal amount, String currency, String direction, String description) {}
    public record BalanceEvent(String eventType, Long account_id, String currency, BigDecimal newBalance) {}

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishAccountCreated(Account account) {
        AccountEvent event = new AccountEvent("ACCOUNT_CREATED", account.getId(), account.getCustomer_id(), account.getCountry());
        logger.info("Publishing AccountCreated event, account_id= {}", account.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.ACCOUNT_QUEUE, event);
    }

    public void publishBalanceUpdated(Long account_id, String currency, BigDecimal newBalance) {
        BalanceEvent event = new BalanceEvent("BALANCE_UPDATED", account_id, currency, newBalance);
        logger.info("Publishing BalanceUpdated event, account_id= {} currency= {}", account_id, currency);
        rabbitTemplate.convertAndSend(RabbitConfig.ACCOUNT_QUEUE, event);
    }

    public void publishTransactionCreated(Transaction transaction) {
        TransactionEvent event = new TransactionEvent("TRANSACTION_CREATED", transaction.getId(),transaction.getAccount_id(),transaction.getAmount(),transaction.getCurrency(),transaction.getDirection().name(),transaction.getDescription());
        logger.info("Publishing TransactionCreated, transaction_id = {}", transaction.getId());
        rabbitTemplate.convertAndSend(RabbitConfig.TRANSACTION_QUEUE, event);
    }   
}
