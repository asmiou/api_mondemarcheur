package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class TypePiece implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @NotBlank(message = "Title cannot be null")
    @NotNull(message = "Title cannot be null")
    @Size(min = 3, max = 255, message = "The name should be between 3 and 255 characters")
    String title;

    @Column(length = 500)
    String description;

    String faIcon;
}
