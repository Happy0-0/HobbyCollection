package com.hobbycollection;

import com.hobbycollection.dto.Collection;
import com.hobbycollection.service.ICollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HobbyCollectionController {

    @Autowired
    private ICollectionService collectionService;
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle the / endpoint
     * @return start
     */
    @RequestMapping("/")
    public String index(Model model) {
        try {
            List<Collection> collections;
            collections = collectionService.fetchAll();
            for (Collection collection : collections) {
                model.addAttribute(collection);
            }
        }
        catch (Exception e) {
            log.warn("No collections found on start");
        }
        return "start";
    }
}