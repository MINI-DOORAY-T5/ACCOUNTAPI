package com.nhnacademy.minidooray.accountapi.dto;

import com.nhnacademy.minidooray.accountapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userId;

    private String password;

    private String email;

    private String state;

}
