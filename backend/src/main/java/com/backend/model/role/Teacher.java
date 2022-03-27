package com.backend.model.role;

import com.backend.model.*;
import lombok.Getter;
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
public class Teacher extends BaseEntity {

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "teacherList")
    private List<LessonRiver> lessonRiverList = new ArrayList<>();

    @ManyToMany(mappedBy = "teacherList")
    private List<LessonIndoorErg> lessonIndoorErgList = new ArrayList<>();

    @ManyToMany(mappedBy = "teacherList")
    private List<LessonIndoorPool> lessonIndoorPoolList = new ArrayList<>();

    @ManyToMany(mappedBy = "teacherList")
    private List<LessonBootcamp> lessonBootcampList = new ArrayList<>();

    @OneToOne
    private User user;
}
