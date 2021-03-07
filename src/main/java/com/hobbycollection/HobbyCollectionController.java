package com.hobbycollection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HobbyCollectionController {
    /**
     * Handle the / endpoint
     * @return start
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Handle the AddEditCollection endpoint
     * @return AddEditCollection
     */
    @RequestMapping("/addEditCollection")
    public String addEditCollection() {
        return "AddEditCollection";
    }
}