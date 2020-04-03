package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * Document
     * Image
     * Video
     */
    String type;
    String fileName;
    String url;
    Date createdAt;
    Date updatedAt;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    Local local;

    //File file;
}
