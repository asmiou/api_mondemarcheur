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
public class Document implements Serializable {

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
    String type;
    String fileName;
    String url;
    String description;
    Date createdAt;
    Date updatedAt;
    boolean isApproved;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    Property property;

}
