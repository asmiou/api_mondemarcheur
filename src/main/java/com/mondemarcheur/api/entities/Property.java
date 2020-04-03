package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Property implements Serializable {
    long id;
    /**
     * Hotel
     * Villa
     * Duplex
     * Centre commercial
     * ...
     */
    String type;
    String title;
    String reference;
    String description;
    String address;
    String city;
    String country;
    String zip;
    double lat;
    double lon;
    Date createdAt;
    Date updatedAt;
    Date buildAt;
    boolean isSponsored;

}
