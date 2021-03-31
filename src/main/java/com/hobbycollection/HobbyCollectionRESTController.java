package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbyCollectionRESTController {
    @Autowired
    private ICollectionService collectionService;

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
}
