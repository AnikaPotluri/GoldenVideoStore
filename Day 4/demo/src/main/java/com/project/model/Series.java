package com.project.model;

public class Series extends Video {
    public Series(String title, String genre) {
        super(title, genre);
    }

    @Override
    public void play() {
        System.out.println("Playing series: " + getTitle());
    }
}
