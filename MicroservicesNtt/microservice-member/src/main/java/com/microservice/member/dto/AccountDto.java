package com.microservice.member.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountNumber;
    private String accountType;
    private Long initialBalance;
    private Boolean accountState;
    private Long accountBalance;
    private Long cliente;
}
