package com.internship.tool.controller;

import com.internship.tool.entity.User;
import com.internship.tool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")

// ✅ VERY IMPORTANT
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ================= REGISTER =================
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        Optional<User> existingUser =
                userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return "Username already exists";
        }

        // SET ROLE
        if (user.getUsername().equalsIgnoreCase("admin")) {
            user.setRole("ADMIN");
        } else {
            user.setRole("USER");
        }

        userRepository.save(user);

        return "User registered successfully";
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        Optional<User> user =
                userRepository.findByUsername(loginUser.getUsername());

        if (user.isPresent()
                &&
                user.get().getPassword()
                        .equals(loginUser.getPassword())) {

            return "LOGIN_SUCCESS";
        }

        throw new RuntimeException("Invalid credentials");
    }
}