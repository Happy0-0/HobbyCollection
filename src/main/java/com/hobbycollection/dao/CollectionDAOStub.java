package com.hobbycollection.dao;


import com.hobbycollection.dto.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionDAOStub implements ICollectionDAO{

    Map<Integer, Collection> allCollections = new HashMap<>();

    /**
     * Gets a array list of all collections
     * @return List of collections
     */
    @Override
    public ArrayList<Collection> fetchAll() {
        return new ArrayList<>(allCollections.values());
    }

    /**
     * Get an distinct collection in the database.
     * @param id unique integer that belongs to a collection
     * @return Collection object of corresponding id
     */
    @Override
    public ArrayList<Collection> fetchCollectionByName(String name) { return new ArrayList<>(); }

    @Override
    public Collection getItemByID(int id) {

        return allCollections.get(id);
    }


    /**
     * Saves a collection to the database by ID
     * @param collection collection Object
     * @return item collection
     * @throws Exception
     */
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

    /**
     * Deletes a collection from the database by ID
     * @param id unique integer that belongs to a collection
     * @throws Exception
     */
    @Override
    public void delete(int id) throws Exception {
        try {
            allCollections.remove(id);
        } catch(Exception e){
            throw new Exception("Error while deleting a collection");
        }
    }
}
