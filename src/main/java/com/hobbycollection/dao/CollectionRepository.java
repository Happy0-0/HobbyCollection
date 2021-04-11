package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CollectionRepository extends CrudRepository<Collection, Integer> {
    ArrayList<Collection> findByCollectionNameContainingIgnoreCase(String collectionName);
}
