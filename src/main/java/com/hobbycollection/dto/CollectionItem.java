package com.hobbycollection.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
public class CollectionItem {
    private String name;
    private String tags;
    private String description;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;

    public CollectionItem() {

    }

    @OneToOne(mappedBy = "collectionItem")
    private Photo photo;
}
