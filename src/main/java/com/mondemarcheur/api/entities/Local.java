package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Local implements Serializable {

    long id;
    String reference;
    /**
     * Appartemnt
     * Salle
     */
    String category;

    /**
     * Appartemnt : T1, T2, T3, T4, T5
     * Salle: Mariage, conference, concert, bureau, ...
     */
    String type;
    String num;
    String airing;
    String floor;
    String description;
    double price;
    String cadencePayment;
    int quantity;
    double surface;
    boolean isAvailable;
    Date createdAt;
    Date updatesAt;
}
