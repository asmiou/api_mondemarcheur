package com.mondemarcheur.api.entities;

import java.io.Serializable;
import java.util.Date;

public class Status implements Serializable {
    long id;
    Date addedAt;
    String comment;
}
