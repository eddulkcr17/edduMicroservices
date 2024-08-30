package com.microservice.member.persistence;

import com.microservice.member.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.accountId = :idAccount")
    List<Client> findAllClient(Long idAccount);
}
