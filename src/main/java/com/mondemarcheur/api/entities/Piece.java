package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Piece implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    double area;
    int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    TypePiece type;
}
