package com.hobbycollection.dao;

import com.hobbycollection.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPhotoDAO {

    /**
     * Saves a photo to the photo repository
     * @param photo
     */
    void save(Photo photo);

    /**
     * Saves an image to the photos folder locally and sets the path of the photo
     * @param imageURL of the given photo from the user
     * @param photo object
     * @throws IOException
     */
    void saveImage(MultipartFile imageURL, Photo photo) throws IOException;
}
