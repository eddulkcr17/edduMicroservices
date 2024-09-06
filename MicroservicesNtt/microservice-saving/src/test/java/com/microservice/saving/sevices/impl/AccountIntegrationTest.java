package com.microservice.saving.sevices.impl;

import com.microservice.saving.entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAllAccounts() {
        ResponseEntity<Account[]> response = restTemplate.getForEntity(createURL("/findAll"), Account[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        Account[] accounts = response.getBody();
        Assertions.assertNotNull(accounts);
        Assertions.assertTrue(accounts.length > 0, "Debe haber cuentas en la lista");
    }

    @Test
    void testGetAccountById() {
        ResponseEntity<Account> response = restTemplate.getForEntity(createURL("/find/1"), Account.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        Account account = response.getBody();
        Assertions.assertNotNull(account);
        Assertions.assertEquals(1L, account.getCliente());
    }

    @Test
    void testCreateAccount() {

        Account newAccount = new Account();
        newAccount.setAccountNumber(Long.valueOf("123456"));

        ResponseEntity<Account> response = restTemplate.postForEntity(createURL("/accounts"), newAccount, Account.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Account account = response.getBody();
        Assertions.assertNotNull(account);
        Assertions.assertEquals("123456", account.getAccountNumber());
    }

    @Test
    void testDeleteAccount() {
        restTemplate.delete(createURL("/accounts/1"));

        ResponseEntity<Account> response = restTemplate.getForEntity(createURL("/accounts/1"), Account.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    private String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }
}
