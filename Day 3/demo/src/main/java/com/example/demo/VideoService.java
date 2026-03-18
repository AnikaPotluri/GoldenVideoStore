package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {
    private final List<Video> videos = new ArrayList<>();

    @PostConstruct
    public void init() {
        videos.add(new Movie("Inception", "Sci-Fi"));
        videos.add(new Series("Stranger Things", "Horror"));
    }

    public List<Video> getAllVideos() {
        return videos;
    }

    public List<Video> getAvailableVideos() {
        return videos.stream().filter(Video::isAvailable).collect(Collectors.toList());
    }

    public Video addMovie(VideoRequest request) {
        Movie movie = new Movie(request.getTitle(), request.getGenre());
        videos.add(movie);
        return movie;
    }

    public Optional<Video> findVideoByTitle(String title) {
        return videos.stream().filter(v -> v.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public boolean rentVideo(String title) {
        Optional<Video> optional = findVideoByTitle(title);
        optional.ifPresent(Video::rentVideo);
        return optional.isPresent();
    }

    public boolean returnVideo(String title) {
        Optional<Video> optional = findVideoByTitle(title);
        optional.ifPresent(Video::returnVideo);
        return optional.isPresent();
    }
}
