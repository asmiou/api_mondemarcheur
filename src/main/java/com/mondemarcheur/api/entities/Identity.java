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
public class Identity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String firstName;
    String lastName;
    String gender;
    String phone;
    Date birthday;
    Date updatedAt;
    String address;
    String country;
    String city;
    String zip;

    @OneToOne(cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    User user;

}
