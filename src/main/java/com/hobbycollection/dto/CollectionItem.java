package com.hobbycollection.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CollectionItem {
    private String name;
    private String tags;
    private String description;
    private int ID;

    public CollectionItem() {

    }

    public CollectionItem(String name, String tags, String description) {
        this.name = name;
        this.tags = tags;
        this.description = description;
    }
}
