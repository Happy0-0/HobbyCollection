package com.hobbycollection.dao;

import com.hobbycollection.dto.CollectionItem;

import java.util.ArrayList;

public interface ICollectionItemDAO {
    ArrayList<CollectionItem> fetchAll();
    CollectionItem getItemByID(int id);
    CollectionItem save(CollectionItem collectionItem) throws Exception;
    void delete(int id);
}
