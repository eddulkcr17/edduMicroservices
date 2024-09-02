package com.microservice.member.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CLIENT")
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", updatable = false, nullable = false)
    private Long clientId;

    @Column(name = "contrasena",nullable = false)
    private String clientPass;
    @Column(name = "estado",nullable = false)
    private boolean clientState;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_cliente", nullable = false)
    private Person person;
}
