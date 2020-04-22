package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Property implements Serializable {
    public Property(){
        this.createdAt=new Date();
        this.isApproved = false;
        this.isSponsored = false;
    }

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

    @NotBlank(message = "Title cannot be null")
    @NotNull(message = "Title cannot be null")
    @Size(min = 3, max = 255, message = "The property name should be between 3 and 255 characters")
    String title;

    String reference;

    @Column(length = 1000)
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

    @PastOrPresent(message = "Future date do not accepted")
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
