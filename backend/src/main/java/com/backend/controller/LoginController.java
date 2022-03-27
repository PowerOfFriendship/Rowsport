package com.backend.controller;

import com.backend.dto.SuccessfulLoginDTO;
import com.backend.dto.user.UserLoginDataDTO;
import com.backend.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public ResponseEntity<SuccessfulLoginDTO> login(@RequestBody UserLoginDataDTO loginData) {
        return ResponseEntity.ok().body(loginService.login(loginData));
    }


}
