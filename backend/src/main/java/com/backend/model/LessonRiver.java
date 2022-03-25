package com.backend.model;


import com.backend.model.role.Student;
import com.backend.model.role.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
            name = "PERSISTENCE_LESSON_RIVER_STUDENT",
            joinColumns = @JoinColumn(name = "LESSON_RIVER_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> studentList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "PERSISTENCE_LESSON_RIVER_STUDENT",
            joinColumns = @JoinColumn(name = "LESSON_RIVER_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Teacher> teacherList = new ArrayList<>();



}
