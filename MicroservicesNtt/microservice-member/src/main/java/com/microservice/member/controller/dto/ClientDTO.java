package com.microservice.member.controller.dto;

import com.microservice.member.entities.Person;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    private Long clientId;

    private String clientPass;

    private boolean clientState;

    private Person person;

    private String personDNI;

    private String personName;

    private String personGenre;

    private Integer personAge;

    private String personAddress;

    private String personPhone;
}
