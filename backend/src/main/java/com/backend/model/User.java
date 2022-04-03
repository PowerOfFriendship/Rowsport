package com.backend.model;

import com.backend.model.role.Role;
import com.backend.model.role.Student;
import com.backend.model.role.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class User extends BaseEntity {

    private String username;

    private String name;

    private String surname;

    private String telephone;

    private String email;

    @JsonIgnore
    private String password;

    @OneToOne
    private Student student;

    @OneToOne
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSISTENCE_USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID")},
    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

}

