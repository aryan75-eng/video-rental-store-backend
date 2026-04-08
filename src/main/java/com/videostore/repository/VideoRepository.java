package com.videostore.repository;

import com.videostore.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findByTitleIgnoreCase(String title);
    boolean existsByTitleIgnoreCase(String title);
}
