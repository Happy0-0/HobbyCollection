package com.hobbycollection.dao;

import com.hobbycollection.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class PhotoDAO implements IPhotoDAO{

    @Autowired
    private PhotoRepository photoRepository;

    /**
     * Saves a photo to the photo repository
     * @param photo
     */
    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }


    /**
     * Saves an image to the photos folder locally and sets the path of the photo
     * @param imageURL of the given photo from the user
     * @param photo object
     * @throws IOException
     */
    @Override
    public void saveImage(MultipartFile imageURL, Photo photo) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/photos/");
        byte[] bytes = imageURL.getBytes();
        Path path = Paths.get(photo.getPath() + imageURL.getOriginalFilename());
        Files.write(path, bytes);
    }
}
