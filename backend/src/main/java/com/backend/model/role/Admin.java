package com.backend.model.role;

import com.backend.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Admin extends User {

    private boolean active;

}
