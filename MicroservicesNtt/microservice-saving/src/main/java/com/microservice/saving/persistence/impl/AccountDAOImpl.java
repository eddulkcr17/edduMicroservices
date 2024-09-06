package com.microservice.saving.persistence.impl;

import com.microservice.saving.entities.Account;
import com.microservice.saving.persistence.IAccountDAO;
import com.microservice.saving.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountDAOImpl implements IAccountDAO {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
