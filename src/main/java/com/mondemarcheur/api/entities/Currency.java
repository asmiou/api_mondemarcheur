package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @NotNull(message = "Currency label cannot be null")
    @NotBlank(message = "Currency label cannot be null")
    String label;

    @Column(unique = true)
    @NotNull(message = "Currency iso cannot be null")
    @NotBlank(message = "Currency iso cannot be null")
    String iso;

    String icon;

    String flag;

    long rateFrom;

    /*
    @OneToMany(mappedBy = "currencyFrom",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    Set<Rate> rateFrom;*/
}
