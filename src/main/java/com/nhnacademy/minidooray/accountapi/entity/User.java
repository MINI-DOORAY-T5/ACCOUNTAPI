package com.nhnacademy.minidooray.accountapi.entity;

import com.nhnacademy.minidooray.accountapi.State;
import com.nhnacademy.minidooray.accountapi.dto.UserDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_state")
    @Enumerated(EnumType.STRING)
    private State userState;

    @Builder
    public User(String userId, String userPassword, String userEmail, State userState) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userState = userState;
    }


    public User(String id, String email, String pw) {
        this.userId = id;
        this.userEmail = email;
        this.userPassword = pw;
        this.userState = State.active;
    }

    //DTO를 user로
    public User(UserDTO userDTO) {
        this.userId = userDTO.getId();
        this.userEmail = userDTO.getEmail();
        this.userPassword = userDTO.getPassword();
        this.userState = State.valueOf(userDTO.toString());
    }

    public User() {

    }


}
