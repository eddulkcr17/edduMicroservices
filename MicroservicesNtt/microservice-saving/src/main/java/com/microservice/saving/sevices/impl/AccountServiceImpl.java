package com.microservice.saving.sevices.impl;

import com.microservice.saving.entities.Account;
import com.microservice.saving.persistence.IAccountDAO;
import com.microservice.saving.sevices.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountDAO.findById(id);
    }

    @Override
    public void save(Account account) {
        accountDAO.save(account);
    }

    @Override
    public void deleteById(Long id) {
        accountDAO.deleteById(id);
    }

}
