package com.microservice.member.services.impl;

import com.microservice.member.client.AccountClient;
import com.microservice.member.entities.Client;
import com.microservice.member.persistence.IClientDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceImplTest {

    @Mock
    private IClientDAO clientDAO;

    @Mock
    private AccountClient accountClient;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {

        Client client1 = new Client();
        Client client2 = new Client();
        List<Client> clients = List.of(client1, client2);

        Mockito.when(clientDAO.findAll()).thenReturn(clients);

        List<Client> result = clientService.findAll();

        assertEquals(2, result.size(), "clientes en la lista");
        Mockito.verify(clientDAO, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        Long clientId = 1L;
        Client client = new Client();
        client.setClientId(clientId);

        when(clientDAO.findById(clientId)).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.findById(clientId);

        assertTrue(result.isPresent(), "El cliente debería estar presente");
        assertEquals(clientId, result.get().getClientId(), "El ID del cliente debería coincidir");
        verify(clientDAO, times(1)).findById(clientId);
    }

    @Test
    void testFindByIdNotFound() {
        Long clientId = 2L;

        when(clientDAO.findById(clientId)).thenReturn(Optional.empty());

        Optional<Client> result = clientService.findById(clientId);

        assertFalse(result.isPresent(), "El cliente no debería estar presente");
        verify(clientDAO, times(1)).findById(clientId);
    }

    @Test
    void testSave() {
        Client client = new Client();
        client.setClientId(1L);
        client.setPersonName("Eduardo Jaramillo");

        clientService.save(client);

        verify(clientDAO, times(1)).save(client);
    }

    @Test
    void testDeleteById() {
        Long clientId = 1L;

        clientService.deleteById(clientId);

        verify(clientDAO, times(1)).deleteById(clientId);
    }
}