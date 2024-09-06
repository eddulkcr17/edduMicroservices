package com.microservice.saving.sevices.impl;

import com.microservice.saving.entities.Movements;
import com.microservice.saving.persistence.IMovementDAO;
import com.microservice.saving.sevices.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements IMovementService {

    @Autowired
    private IMovementDAO movementDAO;

    @Override
    public List<Movements> findAll() {

        return movementDAO.findAll();
    }

    @Override
    public Optional<Movements> findById(Long id) {
        return movementDAO.findById(id);
    }

    @Override
    public List<Movements> findByDateRange(Date minDate, Date maxDate) {
        return movementDAO.findByDateRange(minDate, maxDate);
    }

    @Override
    public void save(Movements movements) {

        movementDAO.save(movements);
    }

    @Override
    public void deleteById(Long id) {
        movementDAO.deleteById(id);
    }
}
