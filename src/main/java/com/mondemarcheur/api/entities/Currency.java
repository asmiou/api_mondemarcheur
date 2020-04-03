package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
    String label;
    String iso;
    String icon;
    String flag;

    @OneToMany(mappedBy = "currencyFrom",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    Set<Rate> rateFrom;
}
