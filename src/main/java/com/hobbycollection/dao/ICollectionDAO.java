package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;

import java.util.ArrayList;

public interface ICollectionDAO {

    /**
     * Fetches all of the collections
     * @return
     */
    ArrayList<Collection> fetchAll();

    /**
     * Fetches a collection by its name
     * @param name
     * @return
     */
    ArrayList<Collection> fetchCollectionByName(String name);

    /**
     * Gets a collection by its ID
     * @param id
     * @return
     */
    Collection getCollectionByID(int id);

    /**
     * Saves a collection
     * @param collection
     * @return
     * @throws Exception
     */
    Collection save(Collection collection) throws Exception;

    /**
     * Deletes a collection by its ID
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;
}
