package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {

    long id;
    String name;
    String activity;
    String siret;
    String phone;
    String email;
    Date createdAt;
    Date agreementDate;
    String address;
    String country;
    String city;
    String zip;
    boolean isProfessional;
}
