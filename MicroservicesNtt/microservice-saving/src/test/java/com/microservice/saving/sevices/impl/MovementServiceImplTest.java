package com.microservice.saving.sevices.impl;

import com.microservice.saving.controller.dto.MovementDTO;
import com.microservice.saving.entities.Account;
import com.microservice.saving.entities.Movements;
import com.microservice.saving.persistence.IMovementDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovementServiceImplTest {

    @Mock
    private IMovementDAO movementDAO;

    @InjectMocks
    private MovementServiceImpl movementService;

    private Movements movements;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        movements = new Movements();
        movements.setMovementDate(new Date());
        movements.setMovementValue(BigDecimal.valueOf(300));
        movements.setAccount(new Account());
        movements.setMovementId(Long.valueOf(1));
    }

    @Test
    void findAll() {
        when(movementDAO.findAll()).thenReturn(Arrays.asList(movements));
        assertNotNull(movementService.findAll());
    }

    @Test
    void testFindByIdSuccess() {

        Long id = 1L;
        Movements movement = new Movements();
        movement.setMovementId(id);
        when(movementDAO.findById(id)).thenReturn(Optional.of(movement));
        Optional<Movements> result = movementService.findById(id);

        assertTrue(result.isPresent(), "El movimiento debería existir");
        assertEquals(id, result.get().getMovementId(), "El ID del movimiento debería ser igual");

        verify(movementDAO, times(1)).findById(id);
    }

    @Test
    void testFindByIdNotFound() {

        Long id = 2L;

        when(movementDAO.findById(id)).thenReturn(Optional.empty());

        Optional<Movements> result = movementService.findById(id);

        assertFalse(result.isPresent(), "El movimiento no debería existir");

        verify(movementDAO, times(1)).findById(id);
    }

    @Test
    void testSave() {

        movementService.save(movements);

        assertNotNull(movements, "El movimiento guardado no debe ser nulo");
        assertEquals(1L, movements.getMovementId(), "ID del movimiento ");

        verify(movementDAO, times(1)).save(movements);
    }

    @Test
    void testDeleteById() {

        Long movementId = 1L;

        movementService.deleteById(movementId);

        verify(movementDAO, times(1)).deleteById(movementId);
    }

}