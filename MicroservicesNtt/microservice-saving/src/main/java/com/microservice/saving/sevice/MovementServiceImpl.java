package com.microservice.saving.sevice;

import com.microservice.saving.entities.Movements;
import com.microservice.saving.persistence.IMovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovementServiceImpl implements  IMovementService{

    @Autowired
    private IMovementsRepository movementsRepository;

    @Override
    public List<Movements> findAll() {
        return (List<Movements>) movementsRepository.findAll();
    }

    @Override
    public Movements findById(Long id) {
        return movementsRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Movements movements) {
        movementsRepository.save(movements);
    }
}
