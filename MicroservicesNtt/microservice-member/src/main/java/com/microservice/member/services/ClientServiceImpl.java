package com.microservice.member.services;

import com.microservice.member.client.AccountClient;
import com.microservice.member.dto.AccountDto;
import com.microservice.member.entities.Client;
import com.microservice.member.http.response.AccountByClientResponse;
import com.microservice.member.persistence.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountClient accountClient;

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
    public AccountByClientResponse findAccountByClient(Long idClient) {

        //Consultar cliente
        Client client = clientRepository.findById(idClient).orElse(new Client());

        //obtener las cuentas
        List<AccountDto> accountDtoList = accountClient.findByAllAccountsByClient(idClient);
        return AccountByClientResponse.builder()
                .Name(client.getPersonName())
                .accountDtoList(accountDtoList)
                .build();
    }

}
