package com.hobbycollection.dao;


import com.hobbycollection.dto.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionDAO implements ICollectionDAO{

    Map<Integer, Collection> allCollections = new HashMap<>();

    @Override
    public ArrayList<Collection> fetchAll() {
        return new ArrayList<>(allCollections.values());
    }

    @Override
    public Collection getItemByID(int id) {
        return allCollections.get(id);
    }

    @Override
    public Collection save(Collection collection) throws Exception {
        int collectionID = collection.getID();
        allCollections.put(collectionID, collection);
        return collection;
    }

    @Override
    public void delete(int id) {
        allCollections.remove(id);
    }
}
