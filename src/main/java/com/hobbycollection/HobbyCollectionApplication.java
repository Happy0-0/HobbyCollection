package com.hobbycollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HobbyCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobbyCollectionApplication.class, args);
    }

}
