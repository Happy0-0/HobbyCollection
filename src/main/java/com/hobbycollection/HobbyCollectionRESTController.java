package com.hobbycollection;

import com.hobbycollection.dao.CollectionDAO;
import com.hobbycollection.dao.ICollectionDAO;
import com.hobbycollection.dto.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HobbyCollectionRESTController {

    ICollectionDAO iCollectionDAO;

    @GetMapping("/api/Collection/fetchByid")
        public Collection collectionFetchById(@RequestParam(value="id") int id){
        try {
            return new Collection("Test", "http://something", "Test Description", 1);
        }
        catch(Exception ex) {
        ex.printStackTrace();
            throw ex;
        }
    }

    @DeleteMapping("/api/Collection/deleteByid")
        public ResponseEntity deleteCollection(@RequestParam(value="id") Integer id){
            try {
                iCollectionDAO.delete(id);
                return new ResponseEntity(HttpStatus.OK);
            }
            catch(Exception ex) {
                ex.printStackTrace();
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

