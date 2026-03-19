package com.package.repository;

import com.package.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    List<VideoEntity> findByAvailableTrue();
    Optional<VideoEntity> findByTitleIgnoreCase(String title);
}