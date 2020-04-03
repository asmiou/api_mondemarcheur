package com.mondemarcheur.api.entities;

import java.util.Date;

public class Payment {
    long id;
    String reference;
    double amount;
    String mode;
    Date payedAt;
    String transaction;
}
