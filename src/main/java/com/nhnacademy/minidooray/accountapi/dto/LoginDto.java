package com.nhnacademy.minidooray.accountapi.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    String userId;
    @NotBlank
    String userPassword;
}
