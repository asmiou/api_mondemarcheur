package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Payment {
    public Payment(){
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String reference;

    @DecimalMin(value = "10.0", message = "Min value of amount should be greater than 10.0")
    double amount;

    String mode;

    Date payedAt;

    Date createdAt;

    String transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    Local reservation;


}
