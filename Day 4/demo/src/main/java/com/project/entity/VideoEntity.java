package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private boolean available;
    private String type;

    public VideoEntity() {
    }

    public VideoEntity(String title, String genre, String type) {
        this.title = title;
        this.genre = genre;
        this.type = type;
        this.available = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
