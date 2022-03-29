package com.backend.service;


import com.backend.dto.LessonAssignmentDTO;
import com.backend.model.LessonIndoorErg;
import com.backend.model.LessonIndoorPool;
import com.backend.model.LessonRiver;
import com.backend.model.role.Student;
import com.backend.repository.LessonIndoorErgRepository;
import com.backend.repository.LessonIndoorPoolRepository;
import com.backend.repository.LessonRiverRepository;
import com.backend.service.user.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class LessonSignupService {

    private final LessonIndoorErgRepository lessonIndoorErgRepository;
    private final LessonIndoorPoolRepository lessonIndoorPoolRepository;
    private final LessonRiverRepository lessonRiverRepository;
    private final StudentService studentService;

    private void assignLesson(Long userId, LessonAssignmentDTO lessonAssignmentDTO) {
        Student assignee = studentService.getStudentByUserId(userId);
        Long lessonId = lessonAssignmentDTO.getLessonId();

        switch (lessonAssignmentDTO.getLessonType()) {
            case "indoorErg":
                assignIndoorErg(assignee, lessonId);
                break;
            case "indoorPool":
                assignIndoorPool(assignee, lessonId);
                break;
            case "river":
                assignRiver(assignee, lessonId);
        }
    }

    private void assignIndoorErg(Student assignee, Long lessonId) {
        LessonIndoorErg assignedLesson = lessonIndoorErgRepository.getById(lessonId);
        assignee.getLessonIndoorErgList().add(assignedLesson);
        studentService.saveStudent(assignee);
        studentService.studentDecreasePrepaidAmount(assignee.getId(), "indoorErg");
    }

    private void assignIndoorPool(Student assignee, Long lessonId) {
        LessonIndoorPool assignedLesson = lessonIndoorPoolRepository.getById(lessonId);
        assignee.getLessonIndoorPoolList().add(assignedLesson);
        studentService.saveStudent(assignee);
        studentService.studentDecreasePrepaidAmount(assignee.getId(), "indoorPool");
    }

    private void assignRiver(Student assignee, Long lessonId) {
        LessonRiver assignedLesson = lessonRiverRepository.getById(lessonId);
        assignee.getLessonRiverList().add(assignedLesson);
        studentService.saveStudent(assignee);
        studentService.studentDecreasePrepaidAmount(assignee.getId(), "river");
    }
}

