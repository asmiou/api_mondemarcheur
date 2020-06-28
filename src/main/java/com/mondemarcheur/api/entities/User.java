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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String email;
    String password;
    boolean isActive;
    Date createdAt;
    Date lastConnect;
    String roles;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Identity identity;

    @OneToOne(mappedBy = "owner",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Company company;

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Reservation> reservation;

    @OneToMany(mappedBy = "addedBy",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Status> actionsDone;

}
