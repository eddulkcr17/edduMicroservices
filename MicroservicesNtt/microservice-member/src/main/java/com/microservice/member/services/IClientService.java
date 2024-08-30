package com.microservice.member.services;

import com.microservice.member.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();
    Client findById(Long id);
    void save(Client client);
    List<Client> findByIdAccount(Long idAccount);
}
