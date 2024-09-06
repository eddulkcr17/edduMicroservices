package com.microservice.saving.mapper;


import com.microservice.saving.controller.dto.MovementDTO;
import com.microservice.saving.entities.Movements;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementDTO movementToMovementDTO(Movements movements);

    Movements movementDTOTomovement(MovementDTO movementDTO);

    List<MovementDTO> movementsToMovementDTOs(List<Movements> movements);

    List<Movements> movementDTOSToMovements(List<MovementDTO> movementDTOS);
}
