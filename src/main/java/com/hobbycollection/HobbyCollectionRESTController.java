package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HobbyCollectionRESTController {
    @Autowired
    private ICollectionService collectionService;

    /**
     * Fetches a collection by the id
     * @param id
     * @return URL
     */
    @GetMapping("/api/Collection/fetchByid")
    public Collection collectionFetchById(@RequestParam(value="id") int id){
        return new Collection("test name", "http://some.url","test description");
    }

    /**
     * Saves a collection to the database
     * @param collection Collection DTO object
     * @return on success, the saved Collection DTO object.  On Failure, return null
     */
    @PostMapping("/api/Collection/save")
    public Object collectionSave(@RequestBody Collection collection){
        try{
            return collectionService.save(collection);
        } catch (Exception e){
            return e.getMessage();
        }
    }

    /**
     * Retrieves a JSON list of matched collections after searching by term
     * @param searchTerm
     * @return ArrayList of results that contain that search term in their name
     */
    @GetMapping("/api/Collection/searchByTerm")
    public ArrayList<Collection> collectionsSearchByTerm(@RequestParam(value="searchTerm") String searchTerm){
        try {
            return collectionService.fetchCollectionByName(searchTerm);
        } catch (Exception e) {
            return null;
        }
    }
}
