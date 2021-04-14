package com.hobbycollection.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public @Data
class Collection implements Serializable {
    private String collectionName;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public Collection() {

    }

    public Collection(String collectionName, String description){
        this.collectionName = collectionName;
        this.description = description;
    }

    @OneToOne(mappedBy = "collection")
    private Photo photo;
}
