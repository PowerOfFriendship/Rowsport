package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
public class User extends BaseEntity {

    private String username;
    private String name;
    private String surname;
    private String telephone;

    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isSuperadmin;

}

