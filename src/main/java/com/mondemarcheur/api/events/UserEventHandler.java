package com.mondemarcheur.api.events;

import com.mondemarcheur.api.entities.User;
import com.mondemarcheur.api.tools.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

@RepositoryEventHandler
public class UserEventHandler {
    //Logger logger = Logger.getLogger("***Class AuthorEventHandler");

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //@HandleBeforeCreate
    /*public void HandleUserBeforeCreate(User user){
        //logger.info("***Inside Author Before Create....");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }*/
}
