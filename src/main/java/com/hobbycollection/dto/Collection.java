package com.hobbycollection.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data
class Collection {
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

    public void setName(String my_collection) {
    }
}
