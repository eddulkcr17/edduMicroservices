package com.microservice.saving.controller;


import com.microservice.saving.entities.Movements;
import com.microservice.saving.sevice.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movements")
public class MovementsController {

    @Autowired(required=true)
    private IMovementService movementService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody Movements movements){movementService.save(movements); }

    @GetMapping("/all")
    public ResponseEntity<?> finAllAccount(){
        return ResponseEntity.ok(movementService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){return ResponseEntity.ok(movementService.findById(id));}
}
