package com.microservice.saving.persistence;

import com.microservice.saving.entities.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountDAO {

    List<Account> findAll();

    Optional<Account> findById(Long id);

    void save(Account account);

    void deleteById(Long id);
}
