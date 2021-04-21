package com.hobbycollection.dao;

import com.hobbycollection.dto.CollectionItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionItemDAO implements ICollectionItemDAO{
    Map<Integer, CollectionItem> allCollectionItems = new HashMap<>();

    /**
     * Fetches all of the CollectionItems
     * @return
     */
    @Override
    public ArrayList<CollectionItem> fetchAll() {
        return new ArrayList<>(allCollectionItems.values());
    }

    /**
     * Gets a collectionItem by its ID
     * @param id
     * @return
     */
    @Override
    public CollectionItem getItemByID(int id) {
        return allCollectionItems.get(id);
    }

    /**
     * Saves a collectionItem
     * @param collectionItem
     * @return
     * @throws Exception
     */
    @Override
    public CollectionItem save(CollectionItem collectionItem) throws Exception {
        Integer collectionItemId = collectionItem.getID();
        allCollectionItems.put(collectionItemId, collectionItem);
        return collectionItem;
    }

    /**
     * Deletes a collectionItem by the ID
     * @param id
     */
    @Override
    public void delete(int id) {
        allCollectionItems.remove(id);
    }
}
