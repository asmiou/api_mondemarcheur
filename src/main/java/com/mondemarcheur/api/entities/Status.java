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
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    Date addedAt;
    String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    TypeStatus type;

    @ManyToOne(fetch = FetchType.LAZY)
    Local reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    User addedBy;

}
