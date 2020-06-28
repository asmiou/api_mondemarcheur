package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Furniture implements Serializable {

    public Furniture(){
        this.quantity=1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeFurniture type;
}
