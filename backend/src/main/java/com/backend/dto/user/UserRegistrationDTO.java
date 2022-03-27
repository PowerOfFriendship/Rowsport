package com.backend.dto.user;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserRegistrationDTO {


    private String username;
    private String name;
    private String surname;
    private String telephone;

    private String email;
    private String password;

}
