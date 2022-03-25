package com.backend.service.user;

import com.backend.dto.SuccessfulLoginDTO;
import com.backend.dto.user.UserLoginDataDTO;
import com.backend.exception.login.InvalidCredentialsException;
import com.backend.exception.login.UserCredentialsEmptyException;
import com.backend.exception.registration.PasswordTooShortException;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.service.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    public boolean checkLoginCredentials(UserLoginDataDTO loginData) {
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

    public SuccessfulLoginDTO login(UserLoginDataDTO loginData) {

        if (checkLoginCredentials(loginData)) {
            User user = userRepository.findByUsername(loginData.getUsername()).orElseThrow(() ->
                    new InvalidCredentialsException("Username and/or password was incorrect!"));

            String token = jwtTokenService.generateToken("Project", user.getUsername(), user.getId());
            return new SuccessfulLoginDTO("ok", token);
        }
        throw new InvalidCredentialsException("Username and/or password was incorrect!");
    }

}
