package com.backend.dto.user;

import lombok.Data;

@Data
public class UserLoginResponseDTO {

    private final String status;
    private final String jwt;

}
