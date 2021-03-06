package com.backend.dto.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserRegistrationDTO {

    private String username;
    private String name;
    private String surname;
    private String telephone;

    private String email;
    private String password;

    private List<String> roles;

}
