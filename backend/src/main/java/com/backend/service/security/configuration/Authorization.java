package com.backend.service.security.configuration;

import com.backend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Authorization {
    private final AuthenticationService authenticationService;

    public User getCurrentUser() {
        return authenticationService.getCurrentUser();
    }

}
