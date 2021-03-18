package com.hobbycollection.dao;

import com.hobbycollection.dto.Collection;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Integer> {
}
