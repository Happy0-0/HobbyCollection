package com.hobbycollection.service;

import java.util.ArrayList;
import java.util.Collection;

public interface ICollectionService {
    Collection getItemByID(int id);
    Collection save(Collection collection) throws Exception;
    ArrayList<Collection> fetchAll();
    void delete(int id);
}
