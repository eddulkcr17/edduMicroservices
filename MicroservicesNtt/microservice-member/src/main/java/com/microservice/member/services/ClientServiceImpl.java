package com.microservice.member.services;

import com.microservice.member.entities.Client;
import com.microservice.member.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return  clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findByIdAccount(Long idAccount) {
        return clientRepository.findAllClient(idAccount);
    }


}
