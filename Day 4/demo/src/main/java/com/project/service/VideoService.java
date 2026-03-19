package com.project.service;

import com.project.entity.VideoEntity;
import com.project.model.VideoRequest;
import com.project.repository.VideoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void init() {
        if (videoRepository.count() == 0) {
            videoRepository.save(new VideoEntity("Inception", "Sci-Fi", "MOVIE"));
            videoRepository.save(new VideoEntity("Stranger Things", "Horror", "SERIES"));
        }
    }

    public List<VideoEntity> getAllVideos() {
        return videoRepository.findAll();
    }

    public List<VideoEntity> getAvailableVideos() {
        return videoRepository.findByAvailableTrue();
    }

    public VideoEntity addMovie(VideoRequest request) {
        VideoEntity movie = new VideoEntity(request.getTitle(), request.getGenre(), "MOVIE");
        return videoRepository.save(movie);
    }

    public Optional<VideoEntity> findVideoByTitle(String title) {
        return videoRepository.findByTitleIgnoreCase(title);
    }

    public boolean rentVideo(String title) {
        Optional<VideoEntity> optional = findVideoByTitle(title);
        optional.ifPresent(video -> {
            video.setAvailable(false);
            videoRepository.save(video);
        });
        return optional.isPresent();
    }

    public boolean returnVideo(String title) {
        Optional<VideoEntity> optional = findVideoByTitle(title);
        optional.ifPresent(video -> {
            video.setAvailable(true);
            videoRepository.save(video);
        });
        return optional.isPresent();
    }
}
