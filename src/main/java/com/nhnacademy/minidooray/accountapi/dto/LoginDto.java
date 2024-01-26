package com.nhnacademy.minidooray.accountapi.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class LoginDto {
    @NotBlank
    String userId;
    @NotBlank
    String userPassword;
}
