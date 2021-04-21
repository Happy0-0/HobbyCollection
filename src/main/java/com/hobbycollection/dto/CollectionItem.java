package com.hobbycollection.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
public @Data class CollectionItem {
    private String name;
    private String tags;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public CollectionItem() {

    }

    public CollectionItem(String name, String tags, String description) {
        this.name = name;
        this.tags = tags;
        this.description = description;
    }

    public void setName(String my_collectionItem) {
        this.name = my_collectionItem;
    }

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="collection_id")
    private Collection collection;

    @OneToOne(mappedBy = "collectionItem")
    private Photo photo;
}
