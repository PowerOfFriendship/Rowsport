package com.backend.controller;

import com.backend.dto.LessonsPaymentIncrementDTO;
import com.backend.dto.user.StudentDTO;
import com.backend.service.user.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentInteractionController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getListOfStudentsDTOs());
    }

    @PatchMapping("/student/{studentId}")
    public ResponseEntity<Object> updateStudentPrepaidLessons(@PathVariable Long studentId, @RequestBody LessonsPaymentIncrementDTO lessonsIncrementDTO) {
        studentService.addPrepaidLessonsToStudent(studentId, lessonsIncrementDTO.getNumberOfLessons());
        return ResponseEntity.ok("ok");
    }

}
