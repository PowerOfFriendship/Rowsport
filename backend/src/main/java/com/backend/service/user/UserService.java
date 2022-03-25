package com.backend.service.user;

import com.backend.dto.UserRegistrationDTO;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private Boolean checkPasswordLength(String password) {
        return password.length() >= 8;
    }

    private Boolean checkEmailValidation(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    private Boolean checkUsername(String username) {
        return userRepository.findByUsername(username).isEmpty() && !username.isBlank();
    }

    private Boolean checkEmail(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    private User saveUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10)));
        userRepository.save(user);
        return user;
    }

}
