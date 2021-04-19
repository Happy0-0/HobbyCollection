package com.hobbycollection.service;

import com.hobbycollection.dao.ICollectionDAO;
import com.hobbycollection.dao.ICollectionItemDAO;
import com.hobbycollection.dao.IPhotoDAO;
import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.CollectionItem;
import com.hobbycollection.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService implements ICollectionService{

    @Autowired
    private ICollectionDAO collectionDAO;
    private ICollectionItemDAO collectionItemDAO;

    @Autowired
    private IPhotoDAO photoDAO;

    public CollectionService() {

    }

    public CollectionService(ICollectionDAO collectionDAO){
        this.collectionDAO = collectionDAO;
    }

    @Override
    @Cacheable(value="collection", key="#id")
    public Collection fetchById(int id) {
        return collectionDAO.getCollectionByID(id);
    }

    @Override
    @CacheEvict(value="collection", key="#id")
    public void delete(int id) throws Exception {
        collectionDAO.delete(id);
    }

    @Override
    public Collection save(Collection collection) throws Exception {
        return collectionDAO.save(collection);
    }

    @Override
    public CollectionItem save(CollectionItem collectionItem) throws Exception {
        return collectionItemDAO.save(collectionItem);
    }

    @Override
    @Cacheable("collections")
    public List<Collection> fetchAll() {
        return collectionDAO.fetchAll();
    }

    @Override
    @Cacheable(value="collection", key="name")
    public ArrayList<Collection> fetchCollectionByName(String name) { return collectionDAO.fetchCollectionByName(name); }

    @Override
    public void saveImage(MultipartFile imageURL, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageURL, photo);

    }
}
