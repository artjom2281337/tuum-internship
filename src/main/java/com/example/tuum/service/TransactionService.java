package com.example.tuum.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tuum.dto.CreateTransactionRequest;
import com.example.tuum.dto.TransactionResponse;
import com.example.tuum.mapper.AccountMapper;
import com.example.tuum.mapper.BalanceMapper;
import com.example.tuum.mapper.TransactionMapper;
import com.example.tuum.message.MessagePublisher;
import com.example.tuum.model.Balance;
import com.example.tuum.model.Currency;
import com.example.tuum.model.Transaction;
import com.example.tuum.model.TransactionDirection;

@Service
public class TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionMapper transactionMapper;
    private final BalanceMapper balanceMapper;
    private final AccountMapper accountMapper;
    private final MessagePublisher messagePublisher;

    public TransactionService(TransactionMapper transactionMapper, BalanceMapper balanceMapper, AccountMapper accountMapper, MessagePublisher messagePublisher) {
        this.transactionMapper = transactionMapper;
        this.balanceMapper = balanceMapper;
        this.accountMapper = accountMapper;
        this.messagePublisher = messagePublisher;
    }

    public List<TransactionResponse> getTransactionByAccountId(Long account_id) {
        logger.info("Finding transaction with id: {}", account_id);
        accountMapper.findById(account_id);

        List<Transaction> transactions = transactionMapper.findByAccountId(account_id);
        return transactions.stream().map(TransactionResponse::fromTransaction).collect(Collectors.toList());
    }

    @Transactional
    public TransactionResponse createTransaction(CreateTransactionRequest request) {
        logger.info("creating transaction for account: {}", request.getAccount_id());

        accountMapper.findById(request.getAccount_id());

        if (!Currency.isValid(request.getCurrency())) {
            System.out.println("currency is not valid");
        }

        TransactionDirection direction;
        try {
            direction = TransactionDirection.valueOf(request.getDirection().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid direction");
        }

        if (request.getAmount() == null || request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("amount invalid");
        }

        Balance balance = balanceMapper.findByIdAndCurrency(request.getAccount_id(),request.getCurrency().toUpperCase());
        BigDecimal newBalance;
        if (direction == TransactionDirection.IN) {
            newBalance = balance.getAvailabe_amount().add(request.getAmount());
        } else {
            if (balance.getAvailabe_amount().compareTo(request.getAmount()) < 0) {
                System.out.println("Insufficient Funds");
            }
            newBalance = balance.getAvailabe_amount().subtract(request.getAmount());
        }

        balance.setAvailabe_amount(newBalance);
        balanceMapper.update(balance);
        logger.info("Balance updated: {} {}", newBalance, request.getCurrency());

        Transaction transaction = new Transaction(request.getAccount_id(), request.getAmount(), request.getCurrency().toUpperCase(), direction, request.getDescription());
        transaction.setBalance_after_transaction(newBalance);
        transactionMapper.insert(transaction);
        logger.info("transaction created, id: {}", transaction.getId());

        messagePublisher.publishTransactionCreated(transaction);
        messagePublisher.publishBalanceUpdated(request.getAccount_id(),request.getCurrency().toUpperCase(), newBalance);

        return TransactionResponse.fromTransaction(transaction);
    }
}
