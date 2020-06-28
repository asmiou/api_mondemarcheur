package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    double rateValues;

    Date updatedAt;

    /*
    @ManyToOne(optional = false,cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    Currency currencyFrom;*/

    /*
    @ManyToOne(optional = false,cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    Currency currencyTo;*/
}
