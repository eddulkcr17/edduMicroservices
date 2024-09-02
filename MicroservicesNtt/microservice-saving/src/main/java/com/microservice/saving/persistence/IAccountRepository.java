package com.microservice.saving.persistence;

import com.microservice.saving.entities.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT c FROM Account c WHERE c.accountId = :idClient")
    List<Account> findByIdClient(Long idClient);
}
