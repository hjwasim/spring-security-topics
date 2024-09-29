package com.hjwasim.springsecurity.service;

import com.hjwasim.springsecurity.dto.RegistrationResponse;
import com.hjwasim.springsecurity.dto.requests.RegistrationRequest;
import com.hjwasim.springsecurity.entity.AppUser;
import com.hjwasim.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        AppUser u = new AppUser();
        u.setUsername(registrationRequest.getUsername());
        u.setPassword(this.passwordEncoder.encode(registrationRequest.getPassword()));
        u.setRole(registrationRequest.getRole());
        AppUser savedUser = this.userRepository.save(u);
        RegistrationResponse response = new RegistrationResponse();
        response.setUsername(savedUser.getUsername());
        response.setMessage("User saved successfully");
        response.setSuccess(true);
        return response;
    }
}
