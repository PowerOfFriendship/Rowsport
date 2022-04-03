package com.backend.service.security;

import com.backend.dto.user.UserLoginRequestDTO;
import com.backend.exception.login.InvalidCredentialsException;
import com.backend.exception.login.UserCredentialsEmptyException;
import com.backend.exception.registration.PasswordTooShortException;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public boolean checkLoginCredentials(UserLoginRequestDTO loginData) {
        if (loginData.getUsername() == null || loginData.getPassword() == null || loginData.getUsername().isBlank() ||
                loginData.getPassword().isBlank()) {
            throw new UserCredentialsEmptyException();
        }

        if (loginData.getPassword().length() < 8) {
            throw new PasswordTooShortException();
        }

        Optional<User> user = userRepository.findByUsername(loginData.getUsername());
        if (user.isEmpty()) {
            return false;
        } else {
            return BCrypt.checkpw(loginData.getPassword(), user.get().getPassword());
        }
    }

    public String login(UserLoginRequestDTO loginData) {

        if (checkLoginCredentials(loginData)) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword()));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginData.getUsername());
            return jwtTokenService.generateToken(userDetails);
        }
        throw new InvalidCredentialsException("Username and/or password was incorrect!");
    }

}
