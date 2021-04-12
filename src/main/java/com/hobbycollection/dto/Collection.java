package com.hobbycollection.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data
class Collection implements Serializable {
    private String collectionName;
    private String imageURL;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public Collection() {

    }

    public Collection(String collectionName, String imageURL, String description){
        this.collectionName = collectionName;
        this.imageURL = imageURL;
        this.description = description;
    }
}
