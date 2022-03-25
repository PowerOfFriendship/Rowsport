package com.backend.service.user;

import com.backend.dto.UserRegistrationDTO;
import com.backend.model.role.Admin;
import com.backend.model.role.Student;
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

    private Student saveStudent(UserRegistrationDTO userDTO) {
        Student student = new Student();
        student.setUsername(userDTO.getUsername());
        student.setEmail(userDTO.getEmail());
        student.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10)));
        userRepository.save(student);
        return student;
    }

    private Admin saveAdmin(UserRegistrationDTO userDTO) {
        Admin admin = new Admin();
        admin.setUsername(userDTO.getUsername());
        admin.setEmail(userDTO.getEmail());
        admin.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10)));
        admin.setActive(true);
        userRepository.save(admin);
        return admin;
    }

}
