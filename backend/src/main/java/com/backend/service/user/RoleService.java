package com.backend.service.user;

import com.backend.model.role.Role;

public interface RoleService {

    Role findByName(String name);

}
