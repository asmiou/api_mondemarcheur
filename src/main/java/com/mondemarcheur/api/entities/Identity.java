package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotNull
    @NotBlank(message = "LastName cannot be null")
    @Size(min = 2, max=60, message = "LastName length should be between 2 and 60 characters")
    String firstName;

    @NotNull
    @NotBlank(message = "firstName cannot be null")
    @Size(min = 2, max=60, message = "firstName length should be between 2 and 60 characters")
    String lastName;

    @Size(max = 1, message = "The gender should be 1 character, choose between [M,F,A]")
    String gender;

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")
    String phone;

    @Past(message = "Future date not accepted")
    Date birthday;

    Date updatedAt;

    String address;

    String country;

    String city;

    String zip;

    @OneToOne(cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    User user;

}
