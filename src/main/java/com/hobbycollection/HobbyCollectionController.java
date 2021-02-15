package com.hobbycollection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbyCollectionController {
    @RequestMapping("/")
    public String index() {
        return "Hobby Collection home page.";
    }
}
