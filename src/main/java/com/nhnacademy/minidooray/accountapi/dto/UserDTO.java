package com.nhnacademy.minidooray.accountapi.dto;

import com.nhnacademy.minidooray.accountapi.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String id;

    private String email;

    private String password;

    private String state;

    //User를 DTO로
    public UserDTO(User user) {
        this.id = user.getUserId();
        this.email = user.getUserEmail();
        this.password = user.getUserPassword();
        this.state = user.getUserState().toString();
    }
}
