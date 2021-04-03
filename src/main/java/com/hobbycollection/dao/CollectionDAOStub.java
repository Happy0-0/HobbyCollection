package com.hobbycollection.dao;


import com.hobbycollection.dto.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionDAOStub implements ICollectionDAO{

    Map<Integer, Collection> allCollections = new HashMap<>();

    @Override
    public ArrayList<Collection> fetchAll() {
        return new ArrayList<>(allCollections.values());
    }

    @Override
    public Collection fetchCollectionByName(String name) { return allCollections.get(name); }

    @Override
    public Collection getItemByID(int id) {
        return allCollections.get(id);
    }

    @Override
    public Collection save(Collection collection) throws Exception {
        try {
            Integer collectionID = collection.getID();
            allCollections.put(collectionID, collection);
            return collection;
        } catch (Exception e){
            throw new Exception("Error while saving a collection");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            allCollections.remove(id);
        } catch(Exception e){
            throw new Exception("Error while deleting a collection");
        }
    }
}
