package com.backend.service.user;

import com.backend.dto.user.UserRegistrationDTO;
import com.backend.model.role.Student;
import com.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private Student saveStudent(UserRegistrationDTO userDTO) {
        Student student = new Student();
        studentRepository.save(student);
        return student;
    }
}
