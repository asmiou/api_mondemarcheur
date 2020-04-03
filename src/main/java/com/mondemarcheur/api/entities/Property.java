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
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * Hotel
     * Villa
     * Duplex
     * Centre commercial
     * Residence privé
     * ...
     */
    //String type;
    String title;
    String reference;
    String description;
    String imageUrl;
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
    boolean isApproved;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeProperty type;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    Company company;

    @OneToMany
    Set<Service> services;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<Local> locals;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<Document> documents;

}
