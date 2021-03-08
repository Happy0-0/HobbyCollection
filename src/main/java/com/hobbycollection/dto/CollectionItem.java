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
        Is this intended to remain empty?
        SonarLint flags this as an empty implementation and recommends filling with nested comments with explanation, an exception
        or suggests completing the implementation.
        */
    }
}
