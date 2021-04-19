package com.hobbycollection.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data
class Collection {
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

    public void setName(String my_collection) {
    }

    @OneToOne(mappedBy = "collection")
    private Photo photo;
}
