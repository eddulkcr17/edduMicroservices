package com.microservice.saving.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movimientos")
public class Movements {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @Column(name = "fecha")
    private Date movementDate;

    @Column(name = "tipo_movimiento")
    private char movementType;

    @Column(name = "valor")
    private BigDecimal movementValue;

    @Column(name = "saldo")
    private BigDecimal movementBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    @JsonIgnore
    private Account account;
}
