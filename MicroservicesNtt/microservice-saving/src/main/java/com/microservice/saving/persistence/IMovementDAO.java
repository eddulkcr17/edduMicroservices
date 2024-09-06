package com.microservice.saving.persistence;

import com.microservice.saving.entities.Movements;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IMovementDAO {

    List<Movements> findAll();

    Optional<Movements> findById(Long id);

    List<Movements> findByDateRange(Date minDate, Date maxDate);

    void save(Movements movements);

    void deleteById(Long id);
}
