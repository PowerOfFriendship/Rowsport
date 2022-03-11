package com.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Student extends BaseEntity {

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String name;
    private String surname;
    private String telephone;

    private int prepaidLessons;
    private int lifetimeTotalLessons;
    private int rating;

    private String email;
    private String password;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonRiver> lessonRiverList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorErg> lessonIndoorErgList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorPool> lessonIndoorPoolList = new ArrayList<>();

}
