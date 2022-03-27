package com.backend.service.user;

import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailConfirmationService {

    private final UserRepository userRepository;



}
