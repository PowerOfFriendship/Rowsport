package com.backend.exception.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidCredentialsException extends RuntimeException {
    private final String message;
}
