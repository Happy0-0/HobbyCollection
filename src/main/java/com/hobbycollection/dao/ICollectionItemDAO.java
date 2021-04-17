package com.hobbycollection.dao;

import com.hobbycollection.dto.CollectionItem;

import java.util.ArrayList;

public interface ICollectionItemDAO {
    ArrayList<CollectionItem> fetchAll();
    CollectionItem save(CollectionItem collectionItem) throws Exception;
    void delete(int id);
    ArrayList<CollectionItem> fetchCollectionItemByName(String name);
    CollectionItem getCollectionItemByID(int id);
}
