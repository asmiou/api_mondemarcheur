package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Local implements Serializable {
    public Local(){
        this.quantity=1;
        this.isAvailable = false;
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    String reference;
    /**
     * Appartemnt
     * Salle
     */
    //String category;

    /**
     * Appartemnt : "t1"=>"T1",
     *         "t1b"=>"T1-bis",
     *         "t2"=>"T2",
     *         "t2b"=>"T2-bis",
     *         "f1"=>"F1",
     *         "f1b"=>"F1-bis",
     *         "f2"=>"F2",
     *         "f2b"=>"F2-bis",
     *         "hr"=>"Hotel Room",
     *         "hs"=>"Hotel Suite",
     *         "vil"=>"Villa"
     * Salle: Mariage, conference, concert, bureau, ...
     */
    //String type;

    String num;

    /**
     * "n"=>"None",
     * "ven"=>"Ventilation",
     *"air"=>"Air conditioner"
     */
    //String airing;

    String floor;

    @Column(length = 500)
    String description;

    @DecimalMin(value = "10.0", message = "Min value of price should be greater than 10.0")
    double price;

    /**
     * "n"=>"Per night",
     * 'm'=>"Per month"
     * 'a'=>"Per activity"
     */
    //String cadencePayment;

    int quantity;

    @DecimalMin(value = "10.0", message = "Min value of surface should be greater than 10.0")
    double surface;

    boolean isAvailable;

    Date createdAt;

    Date updatesAt;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeCategoryLocal category;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeLocal type;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeCadence cadencePayment;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeAiring airing;

    @ManyToOne(fetch = FetchType.LAZY)
    Property property;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    Set<Furniture> furnitures;

    @OneToMany(mappedBy = "local", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<Piece> pieces;

    @OneToMany(mappedBy = "local", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<Media> gallery;

    @OneToMany(mappedBy = "local", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<Reservation> reservations;
}
