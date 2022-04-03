package com.backend.model.role;

import com.backend.model.BaseEntity;
import com.backend.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter @Setter
public class Role extends BaseEntity {

    private String name;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userList;

}
