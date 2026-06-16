package com.pranav.exam.onlineexamsystem.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pranav.exam.onlineexamsystem.dto.LoginRequest;
import com.pranav.exam.onlineexamsystem.entity.User;
import com.pranav.exam.onlineexamsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return "User Not Found";
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}