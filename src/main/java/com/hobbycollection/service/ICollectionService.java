package com.hobbycollection.service;

import java.util.Collection;

public interface ICollectionService {
    Collection getItemByID(int id);
    Collection save(Collection collection) throws Exception;
    void delete(int id);
}
