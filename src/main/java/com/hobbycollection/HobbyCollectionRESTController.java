package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbyCollectionRESTController {
    @Autowired
    private ICollectionService collectionService;
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Fetches a collection by the id
     * @param id
     * @return URL
     */
    @GetMapping("/api/Collection/fetchByid")
    public Object collectionFetchById(@RequestParam(value="id") int id){
        try{
            log.info("Collection with ID of " + id + " has been fetched.");
            return new Collection("test name", "http://some.url","test description");
        }
        catch (Exception e){
            log.error("There was en error finding your collection with ID: " + id);
            return e.getMessage();
        }
    }

    /**
     * Saves a collection to the database
     * @param collection Collection DTO object
     * @return on success, the saved Collection DTO object.  On Failure, return null
     */

    @PostMapping("/api/Collection/save")
    public Object collectionSave(@RequestBody Collection collection){
        try{
            log.info("Collection with ID of " + collection.getID() + " has been saved.");
            return collectionService.save(collection);
        } catch (Exception e){
            log.error("Collection with ID of " + collection.getID() + " had an error on save: " + e.getMessage());
            return e.getMessage();
        }
    }
}
