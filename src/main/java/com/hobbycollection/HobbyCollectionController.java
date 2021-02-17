package com.hobbycollection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbyCollectionController {
    /**
     * Handle the / endpoint
     * @return start
     */
    @RequestMapping("/")
    public String index() {

        return "start";
    }
}
