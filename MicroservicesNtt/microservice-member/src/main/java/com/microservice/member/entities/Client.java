package com.microservice.member.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person{

    @Column(name = "contrasena",nullable = false)
    private String clientPass;
    @Column(name = "estado",nullable = false)
    private boolean clientState;
}
