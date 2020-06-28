package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Piece implements Serializable {
    public Piece(){
        this.quantity = 1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @DecimalMin(value = "10.0", message = "Min value of surface should be greater than 10.0")
    double area;

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    TypePiece type;
}
