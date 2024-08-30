package com.microservice.saving.controller;

import com.microservice.saving.entities.Account;
import com.microservice.saving.sevice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody Account account){accountService.save(account); }

    @GetMapping("/all")
    public ResponseEntity<?> finAllAccount(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){return ResponseEntity.ok(accountService.findById(id));}
}
