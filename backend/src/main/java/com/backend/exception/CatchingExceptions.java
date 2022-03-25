package com.backend.exception;

import com.backend.dto.error.ErrorDTO;
import com.backend.dto.error.MultipleErrorsDTO;
import com.backend.exception.login.InvalidCredentialsException;
import com.backend.exception.login.UserCredentialsEmptyException;
import com.backend.exception.registration.InvalidEmailFormatException;
import com.backend.exception.registration.PasswordTooShortException;
import com.backend.exception.registration.UsernameOrEmailNotUnique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatchingExceptions {

    @ExceptionHandler(UserCredentialsEmptyException.class)
    public static ResponseEntity<Object> emptyCredentials() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO("Field username and/or field password was empty!"));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public static ResponseEntity<Object> invalidLoginCredentials(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidEmailFormatException.class)
    public static ResponseEntity<ErrorDTO> invalidEmailFormat() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Incorrect email format!"));
    }

    @ExceptionHandler(PasswordTooShortException.class)
    public static ResponseEntity<ErrorDTO> passwordTooShort() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Incorrect password format!"));
    }

    @ExceptionHandler(UsernameOrEmailNotUnique.class)
    public static ResponseEntity<MultipleErrorsDTO> usernameAndEmailAlreadyExists(UsernameOrEmailNotUnique e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MultipleErrorsDTO("error", e.getMessages()));
    }

}
