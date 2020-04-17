package com.mondemarcheur.api.services;

import com.mondemarcheur.api.entities.User;
import com.mondemarcheur.api.entities.UserDetailsImpl;
import com.mondemarcheur.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.loginQuery(login);

        user.orElseThrow(() -> new UsernameNotFoundException(login + " not found."));

        return user.map(UserDetailsImpl::new).get();

    }
}
