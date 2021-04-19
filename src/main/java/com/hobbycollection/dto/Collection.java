package com.hobbycollection.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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

    @ToString.Exclude
    @OneToMany
    @JoinColumn(name="collectionItem_id")
    private List<CollectionItem> collectionItem;

    @OneToOne(mappedBy = "collection")
    private Photo photo;
}
