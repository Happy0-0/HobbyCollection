package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.CollectionItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionItemDAO implements ICollectionItemDAO{
    Map<Integer, CollectionItem> allCollectionItems = new HashMap<>();

    @Override
    public ArrayList<CollectionItem> fetchAll() {
        return new ArrayList<>(allCollectionItems.values());
    }

    @Override
    public CollectionItem getItemByID(int id) {
        return allCollectionItems.get(id);
    }

    @Override
    public CollectionItem save(CollectionItem collectionItem) throws Exception {
        int collectionItemId = collectionItem.getID();
        allCollectionItems.put(collectionItemId, collectionItem);
        return collectionItem;
    }

    @Override
    public void delete(int id) {
        allCollectionItems.remove(id);
    }
}
