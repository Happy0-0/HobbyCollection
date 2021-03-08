package com.hobbycollection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/viewCollection")
    public String viewCollectiony() {
        return "viewCollection";
    }
}