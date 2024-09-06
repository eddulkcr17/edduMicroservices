package com.microservice.saving.controller;

import com.microservice.saving.controller.dto.AccountDTO;
import com.microservice.saving.entities.Account;
import com.microservice.saving.mapper.AccountMapper;
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

    @Autowired
    private AccountMapper accountMapper;

  @GetMapping("/find/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<Account> accountOptional = accountService.findById(id);
      if (accountOptional.isPresent()) {
          Account account = accountOptional.get();
          AccountDTO accountDTO = accountMapper.accountToAccountDTO(account);
          return ResponseEntity.ok(accountDTO);
      }
      return ResponseEntity.notFound().build();
  }

  @GetMapping("/findAll")
  public ResponseEntity<?> findAll(){
      try {
          List<Account> accountList = accountService.findAll();
          List<AccountDTO> accountDTOList = accountMapper.accountsToAccountDTOs(accountList);
          return ResponseEntity.ok(accountDTOList);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody AccountDTO accountDTO) throws URISyntaxException {
      if (accountDTO.getAccountNumber() == null || accountDTO.getAccountNumber().describeConstable().isEmpty()) {
          return ResponseEntity.badRequest().build();
      }
      Account account = accountMapper.accountDTOToAccount(accountDTO);
      accountService.save(account);
      return ResponseEntity.created(new URI("/api/accounts/save")).build();
  }

  @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id,@RequestBody AccountDTO accountDTO){
      Optional<Account> accountOptional = accountService.findById(id);
      if (accountOptional.isPresent()) {
          Account account = accountOptional.get();
          account = accountMapper.accountDTOToAccount(accountDTO);
          account.setAccountId(id); // Asegúrate de que el ID se mantenga
          accountService.save(account);
          return ResponseEntity.ok("Cuenta actualizada");
      }
      return ResponseEntity.notFound().build();
  }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            accountService.deleteById(id);
            return ResponseEntity.ok("Cuenta eliminada");
        }
        return ResponseEntity.noContent().build();
    }

}
