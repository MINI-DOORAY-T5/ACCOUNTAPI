package com.nhnacademy.minidooray.accountapi.advice;

import com.nhnacademy.minidooray.accountapi.exception.UserAlreadyExistException;
import com.nhnacademy.minidooray.accountapi.exception.UserNotFoundException;
import com.nhnacademy.minidooray.accountapi.exception.ValidationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(ValidationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> validationFailed(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Content-Type", "application/json;charset=UTF-8")
                .body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> userAlreadyExist(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Content-Type", "application/json;charset=UTF-8")
                .body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> userNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Content-Type", "application/json;charset=UTF-8")
                .body(ex.getMessage());
    }
}
