package com.microservice.saving.persistence;

import com.microservice.saving.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Long> {

}
