package com.microservice.member.services.impl;

import com.microservice.member.client.AccountClient;
import com.microservice.member.dto.AccountDto;
import com.microservice.member.entities.Client;
import com.microservice.member.http.response.AccountByClientResponse;

import com.microservice.member.persistence.IClientDAO;
import com.microservice.member.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientDAO clientDAO;


    @Autowired
    private AccountClient accountClient;

    @Override
    public List<Client> findAll() {

        return clientDAO.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {

        return  clientDAO.findById(id);
    }

    @Override
    public void save(Client client) {
        clientDAO.save(client);
    }

    @Override
    public void deleteById(Long id) {
        clientDAO.deleteById(id);
    }


    public AccountByClientResponse findAccountByClient(Long idClient) {

        //Consultar cliente
        Client client = clientDAO.findById(idClient).orElse(new Client());

        //obtener las cuentas
        List<AccountDto> accountDtoList = accountClient.findByAllAccountsByClient(idClient);
        return AccountByClientResponse.builder()
                .Name(client.getPersonName())
                .accountDtoList(accountDtoList)
                .build();
    }

}
