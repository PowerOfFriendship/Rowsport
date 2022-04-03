package com.backend.controller;

import com.backend.dto.StatusDTO;
import com.backend.dto.user.UserRegistrationDTO;
import com.backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<Object> userRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO) throws RuntimeException {
        userService.addNewUser(userRegistrationDTO);
        StatusDTO status = new StatusDTO("ok");
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }


}
