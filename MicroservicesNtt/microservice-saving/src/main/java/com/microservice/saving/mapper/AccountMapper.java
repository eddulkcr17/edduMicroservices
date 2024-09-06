package com.microservice.saving.mapper;

import com.microservice.saving.controller.dto.AccountDTO;
import com.microservice.saving.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO accountToAccountDTO(Account account);

    Account accountDTOToAccount(AccountDTO accountDTO);

    List<AccountDTO> accountsToAccountDTOs(List<Account> accounts);

    List<Account> accountDTOsToAccounts(List<AccountDTO> accountDTOs);
}
