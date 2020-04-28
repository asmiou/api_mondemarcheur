package com.mondemarcheur.api.services;

import com.mondemarcheur.api.entities.User;
import com.mondemarcheur.api.entities.UserDetailsImpl;
import com.mondemarcheur.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    Collection<GrantedAuthority> authorities = new ArrayList<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*
        Optional<User> user = userRepository.loginQuery(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
        return user.map(UserDetailsImpl::new).get();*/

        /*
        User user = userRepository.userLoginQuery(username);
        if(user ==null) throw new UsernameNotFoundException(username + " not found.");
        authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        */

        User user = userRepository.userLoginQuery(username);
        if(user ==null) throw new UsernameNotFoundException(username + " not found.");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
