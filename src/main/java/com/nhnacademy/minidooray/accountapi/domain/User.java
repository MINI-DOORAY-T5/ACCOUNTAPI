package com.nhnacademy.minidooray.accountapi.domain;

import com.nhnacademy.minidooray.accountapi.Status;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User {
    @Id
    private String userId;

    private String userPassword;

    private String userEmail;

    private Status userStatus;
}
