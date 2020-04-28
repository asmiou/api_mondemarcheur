package com.mondemarcheur.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    //@Pattern(regexp = "^(?=.*\\d)(?=.*[@#\\-_$%^&+=§!\\?])(?=.*[a-z])(?=.*[A-Z])[0-9A-Za-z@#\\-_$%^&+=§!\\?]{8,32}$",
    /*@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,32}$",
    message = "The password must contain at least 8 characters" +
            "at least one lowercase char\n" +
            "at least one uppercase char\n" +
            "at least one digit\n" +
            "at least one special sign of @#-_$%^&+=§!?")*/
    @NotBlank(message = "Password cannot be null")
    @Size(min=8, max = 32, message = "Le mot de passe doit avoir au moins 8 caractères max 32")
    @Column(nullable = false)
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
