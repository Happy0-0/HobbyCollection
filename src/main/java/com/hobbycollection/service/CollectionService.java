package com.hobbycollection.service;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionService implements ICollectionService{
    @Override
    public Collection getItemByID(int id) {
        return null;
    }

    @Override
    public Collection save(Collection collection) throws Exception {
        return collection;
    }

    @Override
    public ArrayList<Collection> fetchAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}