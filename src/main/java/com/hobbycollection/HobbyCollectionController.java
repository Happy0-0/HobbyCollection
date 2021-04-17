package com.hobbycollection;

import com.hobbycollection.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}