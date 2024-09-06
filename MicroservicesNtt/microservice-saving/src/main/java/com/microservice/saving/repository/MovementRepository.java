package com.microservice.saving.repository;

import com.microservice.saving.entities.Movements;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends CrudRepository<Movements, Long> {

    @Query("SELECT m FROM movimientos m WHERE m.movementDate BETWEEN ?1 AND ?2")
    List<Movements> findMovementByDateInRange(Date minDate, Date maxDate);

}
