package com.microservice.saving.persistence;

import com.microservice.saving.entities.Movements;
import org.springframework.data.repository.CrudRepository;

public interface IMovementsRepository extends CrudRepository<Movements, Long> {
}
