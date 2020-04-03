package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    long id;
    String username;
    String email;
    String password;
    boolean isBlocked;
    boolean active;
    Date createdAt;
    Date lastConnect;



}
