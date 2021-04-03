package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HobbyCollectionController {

    @Autowired
    ICollectionService collectionService;

    /**
     * Handle the / endpoint
     * @return start
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/collections")
    public ResponseEntity searchCollections(@RequestParam(value="searchCollectionTerm", required=false, defaultValue="None") String searchCollectionTerm) {
        ArrayList<Collection> collections = collectionService.fetchCollectionByName(searchCollectionTerm);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(collections, headers, HttpStatus.OK);
    }
}