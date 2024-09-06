package com.microservice.saving.controller;

import com.microservice.saving.controller.dto.AccountDTO;
import com.microservice.saving.entities.Account;
import com.microservice.saving.sevices.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

  @Autowired
  private IAccountService accountService;

  @GetMapping("/find/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<Account> accountOptional = accountService.findById(id);
      if (accountOptional.isPresent()){
          Account account = accountOptional.get();

          AccountDTO accountDTO = AccountDTO.builder()
                  .accountNumber(account.getAccountNumber())
                  .accountType(account.getAccountType())
                  .initialBalance(account.getInitialBalance())
                  .accountState(account.getAccountState())
                  .cliente(account.getCliente())
                  .build();
          return  ResponseEntity.ok(accountDTO);
      }
      return ResponseEntity.notFound().build();
  }

  @GetMapping("/findAll")
  public ResponseEntity<?> findAll(){
      try {
          List<AccountDTO> accountList = accountService.findAll()
                  .stream()
                  .map(account -> AccountDTO.builder()
                          .accountId(account.getAccountId())
                          .accountNumber(account.getAccountNumber())
                          .accountType(account.getAccountType())
                          .accountBalance(account.getAccountBalance())
                          .build())
                  .toList();

          return ResponseEntity.ok(accountList);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody AccountDTO accountDTO) throws URISyntaxException {
        if (accountDTO.getAccountNumber().describeConstable().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        accountService.save(Account.builder().accountNumber(accountDTO.getAccountNumber())
                .initialBalance(accountDTO.getInitialBalance())
                .accountType(accountDTO.getAccountType())
                .accountState(accountDTO.getAccountState())
                .build());

        return ResponseEntity.created(new URI("/api/account/save")).build();
  }

  @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id,@RequestBody AccountDTO accountDTO){
      Optional<Account> accountOptional = accountService.findById(id);
      if (accountOptional.isPresent()){
          Account account = accountOptional.get();
          account.setAccountNumber(accountDTO.getAccountNumber());
          account.setAccountBalance(accountDTO.getAccountBalance());
          account.setAccountType(accountDTO.getAccountType());
          account.setAccountState(accountDTO.getAccountState());
          accountService.save(account);
          return ResponseEntity.ok("Cuenta actualizada");
      }
      return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteById(@PathVariable Long id){
      if(id != null){
          accountService.deleteById(id);
          return ResponseEntity.ok("Cuenta eliminada");
      }
      return ResponseEntity.noContent().build();

  }

}
