package com.backend.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class StudentDTO {

    private LocalDateTime createdAt;

    private int prepaidAmount;
    private int lifetimeTotalLessons;
    private int ratingAccountableLessons;
    private int rating;

    private String username;
    private String name;
    private String surname;
    private String telephone;

    private String email;

    private boolean isAdmin;
    private boolean isSuperadmin;

}
