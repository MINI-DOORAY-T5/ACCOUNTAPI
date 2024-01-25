package com.nhnacademy.minidooray.accountapi.domain;

import com.nhnacademy.minidooray.accountapi.Status;
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

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private Status userStatus;

    public User() {
    }

    public User(String userId, String userPassword, String userEmail, Status userStatus) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userStatus = userStatus;
    }

    public String getUserStatusString() {
        return userStatus.getStirng();
    }

    @Getter
    @Setter
    static class UserDTO {
        private String id;
        private String pw;
        private String email;
        private String statu;

        public UserDTO(User user) {
            this.id = user.getUserId();
            this.pw = user.getUserPassword();
            this.email = user.getUserEmail();
            this.statu = user.getUserStatusString();
        }
    }
}
