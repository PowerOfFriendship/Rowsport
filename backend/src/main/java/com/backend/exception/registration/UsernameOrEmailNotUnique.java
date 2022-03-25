package com.backend.exception.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UsernameOrEmailNotUnique extends RuntimeException{
    List<String> messages;
}
