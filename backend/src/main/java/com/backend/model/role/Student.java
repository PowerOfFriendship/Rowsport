package com.backend.model.role;

import com.backend.model.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Student extends BaseEntity {

    private final int ratingQuotient = 20;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private int prepaidLessons;
    private int lifetimeTotalLessons;
    private int ratingAccountableLessons;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonRiver> lessonRiverList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorErg> lessonIndoorErgList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorPool> lessonIndoorPoolList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentList")
    private List<LessonBootcamp> lessonBootcampList = new ArrayList<>();

    @OneToOne
    private User user;

    public int getRating() {
        return this.ratingAccountableLessons / ratingQuotient;
    }


}
