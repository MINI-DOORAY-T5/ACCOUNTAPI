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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    public UserDTO mapDTO() {
        UserDTO dto = new UserDTO(userId,userPassword,userEmail,userState.toString());
        return dto;
    }

}
