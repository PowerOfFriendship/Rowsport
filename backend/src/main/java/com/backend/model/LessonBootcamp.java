package com.backend.model;

import com.backend.model.role.Student;
import com.backend.model.role.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class LessonBootcamp extends Lesson {

    private int enrolledNum;

    @ManyToMany
    @JoinTable(
            name = "PERSISTENCE_LESSON_BOOTCAMP_STUDENT",
            joinColumns = @JoinColumn(name = "LESSON_BOOTCAMP_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> studentList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "PERSISTENCE_LESSON_BOOTCAMP_TEACHER",
            joinColumns = @JoinColumn(name = "LESSON_BOOTCAMP_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    )
    private List<Teacher> teacherList = new ArrayList<>();

}
