package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/available")
    public List<Video> getAvailableVideos() {
        return videoService.getAvailableVideos();
    }

    @PostMapping("/add/movie")
    public ResponseEntity<Video> addMovie(@RequestBody VideoRequest request) {
        Video movie = videoService.addMovie(request);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{title}/rent")
    public ResponseEntity<String> rentVideo(@PathVariable String title) {
        boolean ok = videoService.rentVideo(title);
        if (ok) {
            return ResponseEntity.ok("Video rented: " + title);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{title}/return")
    public ResponseEntity<String> returnVideo(@PathVariable String title) {
        boolean ok = videoService.returnVideo(title);
        if (ok) {
            return ResponseEntity.ok("Video returned: " + title);
        }
        return ResponseEntity.notFound().build();
    }
}
