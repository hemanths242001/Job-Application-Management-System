package com.example.JobApplicationSystem.controller;


import com.example.JobApplicationSystem.dto.JwtResponse;
import com.example.JobApplicationSystem.dto.LoginRequest;
import com.example.JobApplicationSystem.dto.SignupRequest;
import com.example.JobApplicationSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/signup")
    public String register(@RequestBody SignupRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.authenticate(request);
    }
}
