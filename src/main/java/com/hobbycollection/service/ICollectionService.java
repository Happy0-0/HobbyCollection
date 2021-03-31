package com.hobbycollection.service;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.CollectionItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ICollectionService {

    /**
     * Retrieves a collection by its id
     * @param id int value of the unique id for a collection
     * @return Collection or null if the id does not exist
     */
    Collection fetchById(int id);

    /**
     * Deletes a collection using it's id.  This method should
     * also ensure there are no more items in the collection before deleting.
     * @param id int value of the unique id for a collection to be deleted
     * @throws Exception if an error occurs
     */
    void delete(int id) throws Exception;

    /**
     * Saves a collection to the database
     * @param collection instance of Collection
     * @return Collection that was saved
     * @throws Exception if an error occurs
     */
    Collection save(Collection collection) throws Exception;

    /**
     * Retrieves all of the collections
     * @return List<Collection>
     */
    List<Collection> fetchAll();

}
