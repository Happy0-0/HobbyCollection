package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @GetMapping("/collections") // DELETE BEFORE MERGING, is not in use
//    public String searchCollections(@RequestParam(value="searchCollectionTerm", required=false, defaultValue="None") String searchCollectionTerm, Model model) {
//        ArrayList<Collection> collections = collectionService.fetchCollectionByName(searchCollectionTerm);
//        model.addAttribute("collections", collections);
//        return "collections";
//    }
}