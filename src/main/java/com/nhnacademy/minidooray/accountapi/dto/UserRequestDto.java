package com.nhnacademy.minidooray.accountapi.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank
    private String userId;

    @NotBlank
    private String userPassword;
    @Email
    private String userEmail;

}
