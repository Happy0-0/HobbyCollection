package com.hobbycollection.dao;

import com.hobbycollection.dto.CollectionItem;

import java.util.ArrayList;

public interface ICollectionItemDAO {

    /**
     * Fetches all of the CollectionItems
     * @return
     */
    ArrayList<CollectionItem> fetchAll();

    /**
     * Gets a collectionItem by its ID
     * @param id
     * @return
     */
    CollectionItem getItemByID(int id);

    /**
     * Saves a collectionItem
     * @param collectionItem
     * @return
     * @throws Exception
     */
    CollectionItem save(CollectionItem collectionItem) throws Exception;

    /**
     * Deletes a collectionItem by the ID
     * @param id
     */
    void delete(int id);
}
