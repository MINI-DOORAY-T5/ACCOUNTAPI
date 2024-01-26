package com.nhnacademy.minidooray.accountapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class User {
    public enum UserStatus {
        JOIN, QUIT, DORMANCY
    }

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @Column(name = "user_email")
    private String email;

    public User(String userId, String userPassword, String email) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.userStatus = UserStatus.JOIN;
    }
}
