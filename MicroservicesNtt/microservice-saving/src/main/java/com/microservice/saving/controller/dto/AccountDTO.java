package com.microservice.saving.controller.dto;

import com.microservice.saving.entities.Movements;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {


    private Long accountId;

    private Long accountNumber;

    private char accountType;

    private BigDecimal initialBalance;

    private Boolean accountState;

    private BigDecimal accountBalance;

    private String cliente;

    private List<Movements> movimientos = new ArrayList<>();
}

