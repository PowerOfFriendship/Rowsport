package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
public class User extends BaseEntity {

    @NotEmpty
    private String username;
    private String name;
    private String surname;
    @NotEmpty
    private String telephone;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    @Column(name = "enabled")
    private boolean enabled = false;
    private boolean isAdmin = false;
    private boolean isSuperadmin = false;

}

