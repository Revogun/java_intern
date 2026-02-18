package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.User;
import com.example.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setRole("USER");
        return userService.register(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User request) {

        Optional<User> user = userService.login(request.getEmail(), request.getPassword());

        if (user.isPresent()) {
            // Fake JWT for now
            return new Object() {
                public String token = "dummy-jwt-token";
                public User userData = user.get();
            };
        } else {
            return "Invalid credentials";
        }
    }
}

