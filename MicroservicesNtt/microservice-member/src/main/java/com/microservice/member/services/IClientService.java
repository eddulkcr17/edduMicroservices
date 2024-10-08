package com.microservice.member.services;

import com.microservice.member.entities.Client;
import com.microservice.member.http.response.AccountByClientResponse;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<Client> findAll();

    Optional<Client> findById(Long id);

    void save(Client client);

    void deleteById(Long id);
}
