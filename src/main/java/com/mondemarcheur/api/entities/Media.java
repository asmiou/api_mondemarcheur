package com.mondemarcheur.api.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class Media implements Serializable {
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
    File file;
}
