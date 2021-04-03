package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("collectionDAO")
public class CollectionSQLDAO implements ICollectionDAO{

    @Autowired
    CollectionRepository collectionRepository;

    @Override
    public ArrayList<Collection> fetchAll() {
        return null;
    }

    @Override
    public ArrayList<Collection> fetchCollectionByName(String name) {return null;}

    @Override
    public Collection getItemByID(int id) {
        return null;
    }

    @Override
    public Collection save(Collection collection) throws Exception {
        Collection createdCollection = collectionRepository.save(collection);
        return createdCollection;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
