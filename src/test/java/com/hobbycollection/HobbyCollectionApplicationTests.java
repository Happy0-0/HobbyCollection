package com.hobbycollection;

import com.hobbycollection.dao.ICollectionDAO;
import com.hobbycollection.dao.ICollectionItemDAO;
import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.CollectionItem;
import com.hobbycollection.service.CollectionService;
import com.hobbycollection.service.ICollectionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HobbyCollectionApplicationTests {

    @Autowired
    private ICollectionService collectionService;
    private Collection collection = new Collection();
    private CollectionItem collectionItem = new CollectionItem();

    @MockBean
    private ICollectionDAO collectionDAO;
    private ICollectionItemDAO collectionItemDAO;

    /**
     * Validate that the application runs successfully
     */
    @Test
    void contextLoads() {
    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void verifyCollectionItemProperties() {
        String name =  "Funko Pop";
        String description = "A Spider-man Funko Pop";
        String tag = "Funko";
        String imageUrl = "https://images-na.ssl-images-amazon.com/images/I/71Ll43rYpbL._AC_SX569_.jpg";

        CollectionItem collectionItem = new CollectionItem();
        collectionItem.setName(name);
        assertEquals(name, collectionItem.getName());

        collectionItem.setDescription(description);
        assertEquals(description, collectionItem.getDescription());

        collectionItem.setTags(tag);
        assertEquals(tag, collectionItem.getTags());

        collectionItem.setImageURL(imageUrl);
        assertEquals(imageUrl, collectionItem.getImageURL());
    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void verifyCollectionProperties() {
        String name =  "My Collection";
        String description = "A Funko Pop Collection";
        String imageUrl = "https://mercari-images.global.ssl.fastly.net/photos/m22837971150_1.jpg?1585004637";

        Collection collection = new Collection();
        collection.setCollectionName(name);
        assertEquals(name, collection.getCollectionName());

        collection.setDescription(description);
        assertEquals(description, collection.getDescription());

        collection.setImageURL(imageUrl);
        assertEquals(imageUrl, collection.getImageURL());
    }

    @Test
    void fetchCollectionById_returnsFunkoPopCollectionForID1() throws Exception {
        givenCollectionDataIsAvailable();
        whenCollection1IsAdded();
        whenSearchCollectionWithID1();
        thenReturnFunkoPopCollectionForID1();
    }

    private void givenCollectionDataIsAvailable() throws Exception {
        Mockito.when(collectionDAO.save(collection)).thenReturn(collection);
        collectionService = new CollectionService(collectionDAO);
    }

    private void whenCollection1IsAdded() {
        Collection newCollection = new Collection();
        collection.setName("My Collection");
        collection.setDescription("A Funko Pop Collection");
        Mockito.when(collectionDAO.getCollectionByID(1)).thenReturn(collection);
    }

    private void whenSearchCollectionWithID1() {
        collection = collectionService.fetchById(1);
    }

    private void thenReturnFunkoPopCollectionForID1() {
        String description = collection.getDescription();
        assertEquals("A Funko Pop Collection", description);
    }

}
