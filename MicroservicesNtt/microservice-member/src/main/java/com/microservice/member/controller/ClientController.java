package com.microservice.member.controller;


import com.microservice.member.controller.dto.ClientDTO;
import com.microservice.member.entities.Client;
import com.microservice.member.entities.Person;
import com.microservice.member.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired(required = true)
    private IClientService clientService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()){
            Client client = clientOptional.get();

            ClientDTO clientDTO = ClientDTO.builder()
                    .clientPass(client.getClientPass())
                    .clientState(client.isClientState())
                    .personName(client.getPersonName())
                    .personPhone(client.getPersonPhone())
                    .personDNI(client.getPersonDNI())
                    .personAddress(client.getPersonAddress())
                    .personGenre(client.getPersonGenre())
                    .personAge(client.getPersonAge())
                    .build();

            return  ResponseEntity.ok(clientDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<ClientDTO> clientList = clientService.findAll()
                    .stream()
                    .map(client -> ClientDTO.builder()
                            .clientPass(client.getClientPass())
                            .clientState(client.isClientState())
                            .personName(client.getPersonName())
                            .personPhone(client.getPersonPhone())
                            .personDNI(client.getPersonDNI())
                            .personAddress(client.getPersonAddress())
                            .personGenre(client.getPersonGenre())
                            .personAge(client.getPersonAge())
                            .build())
                            .toList();
            return ResponseEntity.ok(clientList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        if (clientDTO.getPersonName().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        clientService.save((Client) Person.builder()
                        .personName(clientDTO.getPersonName())
                        .personAddress(clientDTO.getPersonAddress())
                        .personAge(clientDTO.getPersonAge())
                        .personDNI(clientDTO.getPersonDNI())
                        .personGenre(clientDTO.getPersonGenre())
                        .personPhone(clientDTO.getPersonPhone())

                .build());
        return ResponseEntity.created(new URI("/api/account/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id,@RequestBody ClientDTO clientDTO){
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()){
            Client client = clientOptional.get();
            client.setClientState(clientDTO.isClientState());
            client.setClientPass(clientDTO.getClientPass());
            client.setPersonAddress(clientDTO.getPersonAddress());
            client.setPersonAge(clientDTO.getPersonAge());
            client.setPersonDNI(clientDTO.getPersonDNI());
            client.setPersonGenre(clientDTO.getPersonGenre());
            client.setPersonName(clientDTO.getPersonName());
            ;
            return ResponseEntity.ok("Cliente actualizado");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        if(id != null){
            clientService.deleteById(id);
            return ResponseEntity.ok("Cliente eliminada");
        }
        return ResponseEntity.noContent().build();

    }
}
