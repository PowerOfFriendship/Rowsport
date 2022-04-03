package com.backend.model.role;

import com.backend.model.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Student extends BaseEntity {

    @Transient
    private final int ratingQuotient = 20;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private int prepaidAmount;

    private int lifetimeTotalLessons;
    private int ratingAccountableLessons;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonRiver> lessonRiverList;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorErg> lessonIndoorErgList;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonIndoorPool> lessonIndoorPoolList;

    @ManyToMany(mappedBy = "studentList")
    private List<LessonBootcamp> lessonBootcampList;

    @OneToOne
    private User user;

    public int getRating() {
        return this.ratingAccountableLessons / ratingQuotient;
    }


}
