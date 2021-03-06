package com.hobbycollection;

import com.hobbycollection.dao.ICollectionDAO;
import com.hobbycollection.dao.ICollectionItemDAO;
import com.hobbycollection.dto.Collection;
import com.hobbycollection.dto.CollectionItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HobbyCollectionApplicationTests {
    @MockBean
    private ICollectionDAO collectionDAO;
    private ICollectionItemDAO collectionItemDAO;

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
        collection.setName(name);
        assertEquals(name, collection.getName());

        collection.setDescription(description);
        assertEquals(description, collection.getDescription());

        collection.setImageURL(imageUrl);
        assertEquals(imageUrl, collection.getImageURL());
    }

}
