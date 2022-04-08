package com.backend.controller;

import com.backend.dto.user.UserLoginRequestDTO;
import com.backend.dto.user.UserLoginResponseDTO;
import com.backend.exception.login.InvalidCredentialsException;
import com.backend.exception.login.UserCredentialsEmptyException;
import com.backend.exception.registration.PasswordTooShortException;
import com.backend.security.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class UserLoginController {

    private final UserLoginService userLoginService;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDTO loginData) throws
            UsernameNotFoundException,
            InvalidCredentialsException,
            PasswordTooShortException,
            UserCredentialsEmptyException
    {

        return ResponseEntity.ok(new UserLoginResponseDTO("ok",
                userLoginService.login(loginData)));
    }
}
