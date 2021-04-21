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

        CollectionItem collectionItem = new CollectionItem();
        collectionItem.setName(name);
        assertEquals(name, collectionItem.getName());

        collectionItem.setDescription(description);
        assertEquals(description, collectionItem.getDescription());

        collectionItem.setTags(tag);
        assertEquals(tag, collectionItem.getTags());
    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void verifyCollectionProperties() {
        String name =  "My Collection";
        String description = "A Funko Pop Collection";

        Collection collection = new Collection();
        collection.setCollectionName(name);
        assertEquals(name, collection.getCollectionName());

        collection.setDescription(description);
        assertEquals(description, collection.getDescription());
    }

    /**
     * Fetches a collection by its ID and returns a Funko Pop Collection for the ID
     * @throws Exception
     */
    @Test
    void fetchCollectionById_returnsFunkoPopCollectionForID1() throws Exception {
        givenCollectionDataIsAvailable();
        whenCollection1IsAdded();
        whenSearchCollectionWithID1();
        thenReturnFunkoPopCollectionForID1();
    }

    /**
     * Validates that collection data is able to be saved and returned
     * @throws Exception
     */
    private void givenCollectionDataIsAvailable() throws Exception {
        Mockito.when(collectionDAO.save(collection)).thenReturn(collection);
        collectionService = new CollectionService(collectionDAO);
            Collection newCollection = new Collection();
            collection.setName("My Collection");
            collection.setDescription("A Funko Pop Collection");
            Mockito.when(collectionDAO.getCollectionByID(1)).thenReturn(collection);
        }

    /**
     * Validates that collection data can fetch the collection by an ID
     * @throws Exception
     */
    private void whenSearchCollectionWithID1() {
        collection = collectionService.fetchById(1);
    }

    /**
     * Validates that collection data is returned correctly
     * @throws Exception
     */
    private void thenReturnFunkoPopCollectionForID1() {
        String description = collection.getDescription();
        assertEquals("A Funko Pop Collection", description);
    }

    /**
     * Validates that collection data is added to a Collection
     * @throws Exception
     */
    private void whenCollection1IsAdded() {
        Collection newCollection = new Collection();
        collection.setName("My Collection");
        collection.setDescription("A Funko Pop Collection");
        Mockito.when(collectionDAO.getCollectionByID(1)).thenReturn(collection);
    }
}
