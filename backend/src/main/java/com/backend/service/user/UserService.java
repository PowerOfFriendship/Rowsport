package com.backend.service.user;

import com.backend.dto.user.UserRegistrationDTO;
import com.backend.exception.registration.InvalidEmailFormatException;
import com.backend.exception.registration.PasswordTooShortException;
import com.backend.exception.registration.UsernameOrEmailNotUnique;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public void addUser(UserRegistrationDTO userDTO) {
        List<String> errors = new ArrayList<>();
        if (!checkPasswordLength(userDTO.getPassword())) {
            throw new PasswordTooShortException();
        }
        if (!checkEmailValidation(userDTO.getEmail())) {
            throw new InvalidEmailFormatException();
        }
        if (!checkUsername(userDTO.getUsername())) {
            errors.add("Username not unique");
        }
        if (!checkEmail(userDTO.getEmail())) {
            errors.add("Email not unique");
        }
        if (errors.size() > 0) {
            throw new UsernameOrEmailNotUnique(errors);
        }
        User user = saveUser(userDTO);
//        emailConfirmationService.saveEmailConfirmation(user);
//        emailConfirmationService.sendEmailConfirmation(user);
    }

    private User saveUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setTelephone(userDTO.getTelephone());
        user.setEmail(userDTO.getEmail());
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10)));
        userRepository.save(user);
        return user;
    }

}
