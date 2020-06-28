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
    private UserRepository repository;

    //@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
            repository.save(user);
            return user;
        }catch (Exception ex){
            throw new Exception("Error:"+ex);
        }

    }
}
