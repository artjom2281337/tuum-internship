package com.example.tuum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tuum.dto.AccountResponse;
import com.example.tuum.dto.CreateAccountRequest;
import com.example.tuum.mapper.AccountMapper;
import com.example.tuum.mapper.BalanceMapper;
import com.example.tuum.message.MessagePublisher;
import com.example.tuum.model.Account;
import com.example.tuum.model.Balance;
import com.example.tuum.model.Currency;

import java.math.BigDecimal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    private final AccountMapper accountMapper;
    private final BalanceMapper balanceMapper;
    private final MessagePublisher messagePublisher;

    public AccountService(AccountMapper accountMapper, BalanceMapper balanceMapper, MessagePublisher messagePublisher) {
        this.accountMapper = accountMapper;
        this.balanceMapper = balanceMapper;
        this.messagePublisher = messagePublisher;
    }

    public AccountResponse getAccount(Long accountId) {
        logger.info("Finding account with id: {}", accountId);

        Account account = accountMapper.findByIdWithBalances(accountId);

        return AccountResponse.fromAccount(account);
    }




    @Transactional
    public AccountResponse createAccount(CreateAccountRequest request) {
        logger.info("creating account for customer: {}", request.getCustomerId());

        for (String currencyCode : request.getCurrencies()) {
            if (!Currency.isValid(currencyCode)) {
                System.out.println("Invalid currency!" + currencyCode);
            }
        }

        Account account = new Account(request.getCustomerId(), request.getCountry());
        accountMapper.insert(account);
        logger.info("Account created with id: {}", account.getId());

        for (String currencyCode : request.getCurrencies()) {
            Balance balance = new Balance(account.getId(), BigDecimal.ZERO, currencyCode.toUpperCase());
            balanceMapper.insert(balance);
            logger.info("Balance Created! currency: {}", balance.getCurrency());
        }

        Account savedAccount = accountMapper.findByIdWithBalances(account.getId());
        messagePublisher.publishAccountCreated(savedAccount);
        return AccountResponse.fromAccount(savedAccount);

    }


}