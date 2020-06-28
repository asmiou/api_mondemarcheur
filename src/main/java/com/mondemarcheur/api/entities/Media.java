package com.mondemarcheur.api.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Media implements Serializable {
    public Media(){
        this.createdAt = new Date();
    }

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
}
