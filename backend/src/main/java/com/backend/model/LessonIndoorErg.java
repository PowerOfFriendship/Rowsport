package com.backend.model;

import com.backend.model.role.Student;
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
public class LessonIndoorErg extends Lesson {

    private int enrolledNum;

    @ManyToMany
    @JoinTable(
            name = "PERSISTENCE_LESSON_INDOOR_ERG_STUDENT",
            joinColumns = @JoinColumn(name = "LESSON_INDOOR_ERG_LIST_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> studentList = new ArrayList<>();

}
