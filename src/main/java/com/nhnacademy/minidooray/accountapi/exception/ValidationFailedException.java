package com.nhnacademy.minidooray.accountapi.exception;

import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(BindingResult bindingResult) {
        super(bindingResult.getAllErrors().stream()
                .map(error -> new StringBuilder().append("Code :")
                        .append(error.getCode()).append(" message :").append(error.getDefaultMessage())).collect(
                        Collectors.joining("|")));
    }
}
