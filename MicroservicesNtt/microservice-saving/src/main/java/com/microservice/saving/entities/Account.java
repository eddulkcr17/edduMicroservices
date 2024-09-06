package com.microservice.saving.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuentas")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "numero_cuenta")
    private Long accountNumber;

    @Column(name = "tipo_cuenta")
    private char accountType;

    @Column(name = "saldo_inicial")
    private BigDecimal initialBalance;

    @Column(name = "estado")
    private Boolean accountState;

    @Column(name = "saldo_actual")
    private BigDecimal accountBalance;

    @Column(name = "cliente_id")
    private String cliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movements> movimientos = new ArrayList<>();
}
