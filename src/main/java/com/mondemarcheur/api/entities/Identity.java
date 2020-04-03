package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Identity implements Serializable {

    long id;
    String firstName;
    String lastName;
    String gender;
    String phone;
    Date birthday;
    Date updatedAt;
    String address;
    String country;
    String city;
    String zip;
}
