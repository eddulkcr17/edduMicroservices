package com.microservice.saving.sevice;

import com.microservice.saving.entities.Account;
import com.microservice.saving.persistence.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements  IAccountService{

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
