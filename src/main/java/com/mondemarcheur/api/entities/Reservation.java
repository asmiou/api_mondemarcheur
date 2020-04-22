package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation implements Serializable {
    public Reservation(){
        this.createdAt=new Date();
        this.adult = 1;
        this.child = 0;
        this.baby = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String reference;

    @FutureOrPresent
    Date arrivedAt;

    @FutureOrPresent
    Date leavedAt;

    Date createdAt;

    int baby;

    int child;

    int adult;

    @ManyToOne(fetch = FetchType.LAZY)
    Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    User customer;

    @OneToMany(mappedBy = "reservation",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Status> status;

    @OneToMany(mappedBy = "reservation",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Payment> payments;
}
