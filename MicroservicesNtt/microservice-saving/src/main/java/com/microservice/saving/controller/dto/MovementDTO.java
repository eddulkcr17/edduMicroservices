package com.microservice.saving.controller.dto;

import com.microservice.saving.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementDTO {


    private Long movementId;

    private Date movementDate;

    private char movementType;

    private BigDecimal movementValue;

    private BigDecimal movementBalance;

    private Account account;
}
