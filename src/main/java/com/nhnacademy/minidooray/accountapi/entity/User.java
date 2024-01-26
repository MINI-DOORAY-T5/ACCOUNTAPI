package com.nhnacademy.minidooray.accountapi.entity;

import com.nhnacademy.minidooray.accountapi.State;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public User() {
    }

    public User(String userId, String userPassword, String userEmail, State userState) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userState = userState;
    }

    public String getUserStatusString() {
        return userState.getStirng();
    }

    @Getter
    @Setter
    static class UserDTO {
        private String id;
        private String pw;
        private String email;
        private String state;

        public UserDTO(User user) {
            this.id = user.getUserId();
            this.pw = user.getUserPassword();
            this.email = user.getUserEmail();
            this.state = user.getUserStatusString();
        }
    }
}
