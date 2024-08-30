package com.microservice.saving.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name="cuentas")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "numero_cuenta")
    private Long accountNumber;

    @Column(name = "tipo_cuenta")
    private String accountType;

    @Column(name = "saldo_inicial")
    private Long initialBalance;

    @Column(name = "estado")
    private Boolean accountState;

    @Column(name = "saldo_actual")
    private Long accountBalance;


    @Column(name = "cliente_id")
    private Long cliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
    private List<Movements> movimientos = new ArrayList<>();
}
