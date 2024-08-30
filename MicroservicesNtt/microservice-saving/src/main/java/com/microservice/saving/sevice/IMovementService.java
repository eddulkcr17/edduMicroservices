package com.microservice.saving.sevice;


import com.microservice.saving.entities.Movements;

import java.util.List;

public interface IMovementService {

    List<Movements> findAll();
    Movements findById(Long id);
    void save(Movements movements);
}
