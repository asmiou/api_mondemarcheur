package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {
    long id;
    String reference;
    Date arrivedAt;
    Date leavedAt;
    Date createdAt;
    int baby;
    int child;
    int adult;
}
