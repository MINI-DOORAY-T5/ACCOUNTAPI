package com.nhnacademy.minidooray.accountapi.dto;

import com.nhnacademy.minidooray.accountapi.entity.User.UserState;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    @NotBlank
    private String userId;
    @Email
    private String userEmail;
    private UserState userState;
}
