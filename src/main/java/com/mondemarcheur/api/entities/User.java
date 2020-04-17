package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(mappedBy = "user",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Identity identity;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Role> roles;

    @OneToOne(mappedBy = "owner",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Company company;

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Reservation> reservation;

    @OneToMany(mappedBy = "addedBy",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Status> actionsDone;

}
