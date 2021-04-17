package com.hobbycollection.service;

import com.hobbycollection.dto.CollectionItem;
import com.hobbycollection.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ICollectionItemService {

    /**
     * Retrieves a collectionItem by its id
     * @param id int value of the unique id for a collectionItem
     * @return Collection or null if the id does not exist
     */
    CollectionItem fetchById(int id);

    /**
     * Deletes a collectionItem using it's id.
     * @param id int value of the unique id for a collectionItem to be deleted
     * @throws Exception if an error occurs
     */
    void delete(int id) throws Exception;

    /**
     * Saves a collectionItem to the database
     * @param collectionItem instance of Collection
     * @return Collection that was saved
     * @throws Exception if an error occurs
     */
    CollectionItem save(CollectionItem collectionItem) throws Exception;

    /**
     * Retrieves all of the collectionItems
     * @return List<Collection>
     */
    List<CollectionItem> fetchAll();

    /**
     * Retrieves collectionItems by a search term
     * @return List<Collection>
     */
    ArrayList<CollectionItem> fetchCollectionItemByName(String searchCollectionItemTerm);

    /**
     * Saves an image
     * @param imageURL
     * @param photo
     * @throws IOException
     */
    void saveImage(MultipartFile imageURL, Photo photo) throws IOException;
}
