package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
public class User extends BaseEntity {

    protected String username;
    protected String name;
    protected String surname;
    protected String telephone;

    protected String email;
    protected String password;
    protected boolean isAdmin;



}

