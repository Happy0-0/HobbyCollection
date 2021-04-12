package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.Photo;
import com.hobbycollection.service.ICollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
     * Fetches a collection by the name
     * @param collectionName
     * @return URL
     */
    @GetMapping("/api/Collection/fetchByCollectionName")
    public Object collectionFetchByCollectionName(@RequestParam(value="collectionName") String collectionName) {
        try {
            log.info("Collection with ID of " + collectionName + " has been fetched.");
            return collectionService.fetchCollectionByName(collectionName);
        }
        catch (Exception e) {
            log.error("There was en error finding your collection with collection name: " + collectionName);
            return e.getMessage();
        }
    }
    /**
     * Saves a collection to the database
     * @param collection Collection DTO object
     * @return on success, the saved Collection DTO object.  On Failure, return null
     */

    @PostMapping("/api/Collection/save")
    public ModelAndView collectionSave(Collection collection, @RequestParam("imageURL") MultipartFile imageURL, ModelAndView model) {
        ModelAndView modelAndView = new ModelAndView();
        try{
            //return collectionService.saveCollection(imageURL, description, collectionName);
            log.info("Collection with ID of " + collection.getID() + " has been saved.");
            collectionService.save(collection);
        } catch (Exception e){
            log.error("Collection with ID of " + collection.getID() + " had an error on save: " + e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }

        Photo photo = new Photo();
        try {
            photo.setFileName(imageURL.getOriginalFilename());
            collectionService.saveImage(imageURL, photo);
            model.addObject("collection", collection);
            modelAndView.setViewName("success");
        }
        catch (Exception e){
            log.error("Unable to save photo: " + e.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
        return modelAndView;
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

    /**
     * Retrieves all of the collections
     * @return List of collections
     */
    @GetMapping("/api/Collection/fetchAll")
    public List<Collection> collectionFetchAll() {
        try {
            return collectionService.fetchAll();
        }
        catch (Exception e) {
            return null;
        }
    }
}
