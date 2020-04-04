package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String reference;
    Date arrivedAt;
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
