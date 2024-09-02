package com.microservice.member.client;

import com.microservice.member.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-saving", url="localhost:8080/api/account" )
public interface AccountClient {
    @GetMapping("/search-by-client/{idClient}")
    List<AccountDto> findByAllAccountsByClient(@PathVariable Long idClient);
}
