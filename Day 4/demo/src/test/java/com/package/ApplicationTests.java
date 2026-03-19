package com.package;

import com.package.entity.VideoEntity;
import com.package.model.VideoRequest;
import com.package.service.VideoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private VideoService videoService;

    @BeforeEach
    void setup() {
        // no-op: VideoService uses @PostConstruct for seed data
    }

    @Test
    void contextLoads() {
        Assertions.assertNotNull(videoService);
    }

    @Test
    void testInitialVideosPresent() {
        List<VideoEntity> videos = videoService.getAllVideos();
        Assertions.assertTrue(videos.stream().anyMatch(v -> v.getTitle().equalsIgnoreCase("Inception")));
        Assertions.assertTrue(videos.stream().anyMatch(v -> v.getTitle().equalsIgnoreCase("Stranger Things")));
    }

    @Test
    void testAddRentReturnWorkflow() {
        VideoRequest request = new VideoRequest();
        request.setTitle("Interstellar");
        request.setGenre("Sci-Fi");

        VideoEntity created = videoService.addMovie(request);
        Assertions.assertEquals("Interstellar", created.getTitle());
        Assertions.assertTrue(created.isAvailable());

        boolean rented = videoService.rentVideo("Interstellar");
        Assertions.assertTrue(rented);
        Assertions.assertFalse(videoService.findVideoByTitle("Interstellar").get().isAvailable());

        boolean returned = videoService.returnVideo("Interstellar");
        Assertions.assertTrue(returned);
        Assertions.assertTrue(videoService.findVideoByTitle("Interstellar").get().isAvailable());
    }

    @Test
    void testGetAvailableVideosExcludesRented() {
        VideoRequest request = new VideoRequest();
        request.setTitle("Dune");
        request.setGenre("Sci-Fi");

        videoService.addMovie(request);
        videoService.rentVideo("Dune");

        List<VideoEntity> available = videoService.getAvailableVideos();
        Assertions.assertTrue(available.stream().noneMatch(v -> v.getTitle().equalsIgnoreCase("Dune")));
    }

}

