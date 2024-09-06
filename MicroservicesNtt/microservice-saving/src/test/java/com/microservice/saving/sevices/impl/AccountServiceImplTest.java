package com.microservice.saving.sevices.impl;

import com.microservice.saving.entities.Account;
import com.microservice.saving.persistence.impl.AccountDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    @Mock
    private AccountDAOImpl accountDAO;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = List.of(account1, account2);

        Mockito.when(accountDAO.findAll()).thenReturn(accounts);

        List<Account> result = accountService.findAll();

        assertEquals(2, result.size(), "Debe haber dos cuentas en la lista");
        Mockito.verify(accountDAO, Mockito.times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        Long accountId = 1L;
        Account account = new Account();
        account.setAccountId(accountId);

        Mockito.when(accountDAO.findById(accountId)).thenReturn(Optional.of(account));

        Optional<Account> result = accountService.findById(accountId);

        assertTrue(result.isPresent(), "La cuenta debería estar presente");
        assertEquals(accountId, result.get().getAccountId(), "El ID de la cuenta debería coincidir");
        Mockito.verify(accountDAO, Mockito.times(1)).findById(accountId);
    }

    @Test
    void testFindByIdNotFound() {
        Long accountId = 2L;

        Mockito.when(accountDAO.findById(accountId)).thenReturn(Optional.empty());

        Optional<Account> result = accountService.findById(accountId);

        assertFalse(result.isPresent(), "La cuenta no debería estar presente");
        Mockito.verify(accountDAO, Mockito.times(1)).findById(accountId);
    }

    @Test
    void testSave() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setAccountNumber(Long.valueOf("12345"));

        accountService.save(account);

        Mockito.verify(accountDAO, Mockito.times(1)).save(account);
    }

    @Test
    void testDeleteById() {
        Long accountId = 1L;

        accountService.deleteById(accountId);

        Mockito.verify(accountDAO, Mockito.times(1)).deleteById(accountId);
    }
}