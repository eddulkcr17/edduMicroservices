package com.microservice.saving.controller;


import com.microservice.saving.controller.dto.MovementDTO;
import com.microservice.saving.entities.Movements;
import com.microservice.saving.mapper.MovementMapper;
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

    private MovementMapper movementMapper;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Movements> movementsOptional = movementService.findById(id);
        if (movementsOptional.isPresent()){
            Movements movements = movementsOptional.get();

            MovementDTO movementDTO = movementMapper.movementToMovementDTO(movements);
            return  ResponseEntity.ok(movementDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<Movements> movementDTOList = movementService.findAll();
            List<MovementDTO> movementDTOS = movementMapper.movementsToMovementDTOs(movementDTOList);

            return ResponseEntity.ok(movementDTOS);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MovementDTO movementDTO) throws URISyntaxException {
        if (movementDTO.getAccount().getMovimientos().isEmpty() ){
            return ResponseEntity.badRequest().build();
        }
       Movements movements = movementMapper.movementDTOTomovement(movementDTO);

        return ResponseEntity.created(new URI("/api/account/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMovement(@PathVariable Long id,@RequestBody MovementDTO movementDTO){
        Optional<Movements> movementsOptional = movementService.findById(id);
        if (movementsOptional.isPresent()){
           Movements movements = movementsOptional.get();
           movements = movementMapper.movementDTOTomovement(movementDTO);
           movements.setMovementId(id);
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
