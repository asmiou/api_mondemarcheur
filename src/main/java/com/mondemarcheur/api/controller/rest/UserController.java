package com.mondemarcheur.api.controller.rest;

import com.mondemarcheur.api.entities.User;
import com.mondemarcheur.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public void register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
