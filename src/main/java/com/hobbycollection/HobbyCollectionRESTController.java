package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbyCollectionRESTController {

    @GetMapping("/api/Collection/fetchByid")
    public Collection collectionFetchById(@RequestParam(value="id") int id){
        return new Collection("Test", "http://something","Test Description",1 );
    }
}
