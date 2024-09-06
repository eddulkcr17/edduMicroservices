package com.microservice.saving.persistence.impl;

import com.microservice.saving.entities.Movements;
import com.microservice.saving.persistence.IMovementDAO;
import com.microservice.saving.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class MovementDAOImpl implements IMovementDAO {

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public List<Movements> findAll() {
        return (List<Movements>) movementRepository.findAll();
    }

    @Override
    public Optional<Movements> findById(Long id) {
        return movementRepository.findById(id);
    }

    @Override
    public List<Movements> findByDateRange(Date minDate, Date maxDate) {
        return movementRepository.findMovementByDateInRange(minDate, maxDate);
    }

    @Override
    public void save(Movements movements) {
        movementRepository.save(movements);

    }

    @Override
    public void deleteById(Long id) {
        movementRepository.deleteById(id);
    }
}
