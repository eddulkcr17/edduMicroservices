package com.microservice.saving.sevice;

import com.microservice.saving.entities.Account;
import com.microservice.saving.persistence.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
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

    @Override
    public Object findByIdClient(Long idClient) {
        return accountRepository.findByIdClient(idClient);
    }
}
