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
public class LessonRiver extends Lesson {

    private int singleScullCapacity;
    private int doubleScullCapacity;
    private int quadScullCapacity;
    private int eightCapacity;

    private int singleScullEnrolled;
    private int doubleScullEnrolled;
    private int quadScullEnrolled;
    private int eightEnrolled;

    @ManyToMany(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PERSISTENCE_LESSON_RIVER_STUDENT",
            joinColumns = @JoinColumn(name = "LESSON_RIVER_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> studentList = new ArrayList<>();

    @ManyToMany(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PERSISTENCE_LESSON_RIVER_TEACHER",
            joinColumns = @JoinColumn(name = "LESSON_RIVER_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    )
    private List<Teacher> teacherList = new ArrayList<>();



}
