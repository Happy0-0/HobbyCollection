package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;

import java.util.ArrayList;

public interface ICollectionDAO {

    ArrayList<Collection> fetchAll();
    Collection getCollectionByID(int id);
    Collection save(Collection collection) throws Exception;
    void delete(int id) throws Exception;
}
