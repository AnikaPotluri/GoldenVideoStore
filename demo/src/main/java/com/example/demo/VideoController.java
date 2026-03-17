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

    private final List<Video> videos = new ArrayList<>();

    @PostConstruct
    public void init() {
        videos.add(new Movie("Inception", "Sci-Fi"));
        videos.add(new Series("Stranger Things", "Horror"));
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videos;
    }

    @GetMapping("/available")
    public List<Video> getAvailableVideos() {
        return videos.stream().filter(Video::isAvailable).collect(Collectors.toList());
    }

    @PostMapping("/add/movie")
    public ResponseEntity<Video> addMovie(@RequestBody VideoRequest request) {
        Movie movie = new Movie(request.getTitle(), request.getGenre());
        videos.add(movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{title}/rent")
    public ResponseEntity<String> rentVideo(@PathVariable String title) {
        return findVideoByTitle(title).map(video -> {
            video.rentVideo();
            return ResponseEntity.ok("Video rented: " + title);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{title}/return")
    public ResponseEntity<String> returnVideo(@PathVariable String title) {
        return findVideoByTitle(title).map(video -> {
            video.returnVideo();
            return ResponseEntity.ok("Video returned: " + title);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private java.util.Optional<Video> findVideoByTitle(String title) {
        return videos.stream().filter(v -> v.getTitle().equalsIgnoreCase(title)).findFirst();
    }
}
