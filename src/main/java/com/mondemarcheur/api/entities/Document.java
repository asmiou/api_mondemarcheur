package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Document implements Serializable {
    public Document(){
        this.createdAt = new Date();
        this.isApproved = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * "pi"=>"Pièce IDENTITE (Passport, C. d'identité, C. Séjours)",
     * "ci"=>"1.2- C. d'identité",
     * "cs"=>"1.3- C. Séjours",
     * "jl"=>"Justificatif de domicile (Facture Loyer, Electricité, Eaux)",
     * "kb"=>"Extrait k ou K-bis",
     * "rc"=>"Certificat R. Commerce ou R. Travaille",
     * "ap"=>"Pièce attestant l’activité professionnelle",
     * "pf"=>"Titre de propriété du bien immobilier",
     * "atf"=>"Avis de taxe foncière",
     * "pl"=>"Plan de masse de la concession",
     * "tf"=>"Titre foncier",
     * "df"=>"Attestation de donnation foncier"
     */

    @NotNull(message = "Type cannot be null")
    @NotBlank(message = "Type cannot be null")
    String type;

    String fileName;

    String url;

    @Column(length = 500)
    @Max(value = 500, message = "Max length 500 characters")
    String description;

    Date createdAt;

    Date updatedAt;

    boolean isApproved;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    Property property;

}
