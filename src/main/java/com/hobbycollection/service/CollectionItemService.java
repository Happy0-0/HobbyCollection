package com.hobbycollection.service;

import com.hobbycollection.dao.ICollectionItemDAO;
import com.hobbycollection.dao.IPhotoDAO;
import com.hobbycollection.dto.CollectionItem;
import com.hobbycollection.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionItemService implements ICollectionItemService{
    @Autowired
    private ICollectionItemDAO collectionItemDAO;

    @Autowired
    private IPhotoDAO photoDAO;

    public CollectionItemService() {

    }

    public CollectionItemService(ICollectionItemDAO collectionItemDAO){
        this.collectionItemDAO = collectionItemDAO;
    }

    @Override
    @Cacheable(value="collectionItem", key="#id")
    public CollectionItem fetchById(int id) {
        return collectionItemDAO.getCollectionItemByID(id);
    }

    @Override
    @CacheEvict(value="collectionItem", key="#id")
    public void delete(int id) throws Exception {
        collectionItemDAO.delete(id);
    }

    @Override
    public CollectionItem save(CollectionItem collectionItem) throws Exception {
        return collectionItemDAO.save(collectionItem);
    }

    @Override
    @Cacheable("collectionItems")
    public List<CollectionItem> fetchAll() {
        return collectionItemDAO.fetchAll();
    }

    @Override
    @Cacheable(value="collectionItem", key="name")
    public ArrayList<CollectionItem> fetchCollectionItemByName(String name) { return collectionItemDAO.fetchCollectionItemByName(name); }

    @Override
    public void saveImage(MultipartFile imageURL, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageURL, photo);

    }
}
