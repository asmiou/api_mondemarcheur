package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Company implements Serializable {
    public Company(){
        this.createdAt = new Date();
        this.isProfessional = false;
        this.isEnable = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @NotBlank(message = "Name cannot be null")
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 255, message = "The company name should be between 3 and 255 characters")
    String name;

    String activity;

    String siret;

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")
    String phone;

    @Column(unique = true)
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    String email;

    Date createdAt;

    @PastOrPresent(message = "Future date not accepted")
    Date agreementDate;

    String address;

    String country;

    String city;

    String zip;

    boolean isProfessional;

    boolean isEnable;

    @OneToOne(cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    User owner;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Property> property;
}
