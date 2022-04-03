package com.backend.service.security.configuration;

import com.backend.model.User;
import com.backend.service.security.JwtTokenService;
import com.backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@RequestScope
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private User user;
    private final JwtTokenService jwtTokenService;
    private final UserService userService;

    public User getCurrentUser() {
        return user;
    }

    public void authenticateUser(String token) {
        Long userId = jwtTokenService.extractUserId(token);
        user = userService.getUserById(userId);
    }

}
