package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("CollectionDAOStub")
public class CollectionSQLDAO implements ICollectionDAO{

    @Autowired
    CollectionRepository collectionRepository;

    /**
     * Fetches all of the collections
     * @return
     */
    @Override
    public ArrayList<Collection> fetchAll() {
        return null;
    }

    /**
     * Fetches a collection by its name
     * @param name
     * @return
     */
    @Override
    public ArrayList<Collection> fetchCollectionByName(String name) {
            return collectionRepository.findByCollectionNameContainingIgnoreCase(name);
        }

    /**
     * Gets a collection by its ID
     * @param id
     * @return
     */
    public Collection getCollectionByID(int id) {
        return null;
    }

    /**
     * Saves a collection
     * @param collection
     * @return
     * @throws Exception
     */
    @Override
    public Collection save(Collection collection) throws Exception {
        Collection createdCollection = collectionRepository.save(collection);
        return createdCollection;
    }

    /**
     * Deletes a collection by its ID
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(int id) throws Exception {
        collectionRepository.delete(getCollectionByID(id));
    }
}
