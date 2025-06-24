package com.example.JobApplicationSystem.service;


import com.example.JobApplicationSystem.dto.JwtResponse;
import com.example.JobApplicationSystem.dto.LoginRequest;
import com.example.JobApplicationSystem.dto.SignupRequest;
import com.example.JobApplicationSystem.model.Role;
import com.example.JobApplicationSystem.model.User;
import com.example.JobApplicationSystem.repository.UserRepository;
import com.example.JobApplicationSystem.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtils jwtUtils;

    public String registerUser(SignupRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf("ROLE_" + request.getRole().toUpperCase()))
                .build();
        userRepository.save(user);
        return "User registered successfully!";
    }

    public JwtResponse authenticate(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = jwtUtils.generateJwtToken(request.getUsername());
        return new JwtResponse(token);
    }
}
