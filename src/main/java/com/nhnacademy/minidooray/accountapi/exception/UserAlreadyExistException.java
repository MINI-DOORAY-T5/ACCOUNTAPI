package com.nhnacademy.minidooray.accountapi.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super("user가 이미 존재합니다");
    }
}
