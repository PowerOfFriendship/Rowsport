package com.backend.model;

import com.backend.model.role.Student;
import com.backend.model.role.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
public class User extends BaseEntity {

    private String username;
    private String name;
    private String surname;
    private String telephone;

    private String email;
    private String password;

    private boolean isAdmin = false;
    private boolean isSuperadmin = false;

    @OneToOne
    private Student student;

    @OneToOne
    private Teacher teacher;

}

