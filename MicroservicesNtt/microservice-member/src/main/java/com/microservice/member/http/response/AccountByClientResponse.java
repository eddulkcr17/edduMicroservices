package com.microservice.member.http.response;

import com.microservice.member.dto.AccountDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountByClientResponse {
    private String Name;
    private List<AccountDto> accountDtoList;

}
