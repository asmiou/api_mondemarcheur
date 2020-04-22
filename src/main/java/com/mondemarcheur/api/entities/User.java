package com.mondemarcheur.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class User implements Serializable {
    public User(){
        this.createdAt = new Date();
        //this.isActive =false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @Pattern(regexp = "^[a-z0-9]*$")
    @NotBlank(message = "Login cannot be null")
    String username;

    @Column(unique = true)
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    String email;

    @NotBlank(message = "Password cannot be null")
    @Size(min=6, max = 255, message = "Le mot de passe doit avoir au moins 6 caractère")
    @Column(length = 255, nullable = false)
    @JsonIgnore
    String password;

    boolean isActive;

    Date createdAt;

    Date lastUpdated;

    String roles;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Identity identity;

    @OneToOne(mappedBy = "owner",cascade = {CascadeType.ALL}, optional = true, fetch = FetchType.LAZY)
    Company company;

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Reservation> reservation;

    @OneToMany(mappedBy = "addedBy",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Status> actionsDone;

}
