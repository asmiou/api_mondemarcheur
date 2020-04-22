package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Service implements Serializable {
    public Service(){
        this.isFree = false;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String title;

    String faIcon;
    boolean isFree;
}
