package com.microservice.saving.controller;


import com.microservice.saving.controller.dto.MovementDTO;
import com.microservice.saving.entities.Movements;
import com.microservice.saving.sevices.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movements")
public class MovementsController {

    @Autowired(required=true)
    private IMovementService movementService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Movements> movementsOptional = movementService.findById(id);
        if (movementsOptional.isPresent()){
            Movements movements = movementsOptional.get();

            MovementDTO movementDTO = MovementDTO.builder()
                    .movementDate(movements.getMovementDate())
                    .movementType(movements.getMovementType())
                    .account(movements.getAccount())
                    .movementValue(movements.getMovementValue())
                    .movementBalance(movements.getMovementBalance())
                    .build();
            return  ResponseEntity.ok(movementDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<MovementDTO> movementDTOList = movementService.findAll()
                    .stream()
                    .map(movements -> MovementDTO.builder()
                            .movementDate(movements.getMovementDate())
                            .movementType(movements.getMovementType())
                            .account(movements.getAccount())
                            .movementValue(movements.getMovementValue())
                            .movementBalance(movements.getMovementBalance())
                            .build())
                    .toList();

            return ResponseEntity.ok(movementDTOList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MovementDTO movementDTO) throws URISyntaxException {
        if (movementDTO.getAccount().getMovimientos().isEmpty() ){
            return ResponseEntity.badRequest().build();
        }
        movementService.save(Movements.builder()
                .movementDate(movementDTO.getMovementDate())
                .movementType(movementDTO.getMovementType())
                .account(movementDTO.getAccount())
                .movementValue(movementDTO.getMovementValue())
                .movementBalance(movementDTO.getMovementBalance())
                .build());

        return ResponseEntity.created(new URI("/api/account/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMovement(@PathVariable Long id,@RequestBody MovementDTO movementDTO){
        Optional<Movements> movementsOptional = movementService.findById(id);
        if (movementsOptional.isPresent()){
            Movements movements = movementsOptional.get();
            movements.setMovementDate(movementDTO.getMovementDate());
            movements.setMovementType(movementDTO.getMovementType());
            movements.setMovementValue(movementDTO.getMovementValue());
            movements.setAccount(movementDTO.getAccount());
            movementService.save(movements);
            return ResponseEntity.ok("movieminto actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        if(id != null){
            movementService.deleteById(id);
            return ResponseEntity.ok("movimiento eliminado");
        }
        return ResponseEntity.noContent().build();

    }

}
