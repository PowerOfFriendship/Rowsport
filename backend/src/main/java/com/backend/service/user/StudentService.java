package com.backend.service.user;

import com.backend.dto.user.StudentDTO;
import com.backend.dto.user.UserRegistrationDTO;
import com.backend.exception.NoStudentLinkedToUserException;
import com.backend.model.User;
import com.backend.model.role.Student;
import com.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserService userService;

    private Student saveStudent(UserRegistrationDTO userDTO) {
        Student student = new Student();
        studentRepository.save(student);
        return student;
    }

    private void addPrepaidLessonsToStudent(Long studentId, int numberOfLessons) {

        Student student = studentRepository.getById(studentId);
        student.setPrepaidLessons(student.getPrepaidLessons() + numberOfLessons);
        studentRepository.save(student);

    }

    public Student getStudentByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user.getStudent() != null) {
            return user.getStudent();
        } else throw new NoStudentLinkedToUserException();
    }

    public List<StudentDTO> getListOfStudentsDTOs() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student s :
                studentList) {
            StudentDTO studentDTO = new StudentDTO();
            User user = s.getUser();

            studentDTO.setCreatedAt(s.getCreatedAt());
            studentDTO.setPrepaidLessons(s.getPrepaidLessons());
            studentDTO.setLifetimeTotalLessons(s.getLifetimeTotalLessons());
            studentDTO.setRatingAccountableLessons(s.getRatingAccountableLessons());
            studentDTO.setRating(s.getRating());

            studentDTO.setUsername(user.getUsername());
            studentDTO.setName(user.getName());
            studentDTO.setSurname(user.getSurname());
            studentDTO.setTelephone(user.getTelephone());
            studentDTO.setEmail(user.getEmail());
            studentDTO.setAdmin(user.isAdmin());
            studentDTO.setSuperadmin(user.isSuperadmin());

            studentDTOList.add(studentDTO);
        }
        return  studentDTOList;
    }

}
