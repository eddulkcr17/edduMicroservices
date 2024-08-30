package com.microservice.member.services;

import com.microservice.member.entities.Client;
import com.microservice.member.http.response.AccountByClientResponse;

import java.util.List;

public interface IClientService {

    List<Client> findAll();
    Client findById(Long id);
    void save(Client client);

    AccountByClientResponse findAccountByClient(Long idClient);

}
