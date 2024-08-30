package com.microservice.saving.sevice;

import com.microservice.saving.entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(Long id);
    void save(Account account);

    Object findByIdClient(Long idClient);
}
