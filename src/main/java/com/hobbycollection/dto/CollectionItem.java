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
    private String imageURL;
    private String description;
    private int ID;

    public CollectionItem() {
        /*

        */
    }
}
