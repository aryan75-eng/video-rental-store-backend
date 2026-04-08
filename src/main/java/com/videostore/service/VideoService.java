package com.videostore.service;

import com.videostore.model.Video;
import com.videostore.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepository videoRepository;
    
    @Autowired
    private AuditService auditService;
    
    public Video addVideo(String title) {
        if (videoRepository.existsByTitleIgnoreCase(title)) {
            throw new RuntimeException("Video already exists!");
        }
        Video video = new Video(title);
        Video saved = videoRepository.save(video);
        auditService.logAction("ADD", title, "Video added successfully");
        return saved;
    }
    
    public void removeVideo(String title) {
        Video video = videoRepository.findByTitleIgnoreCase(title)
            .orElseThrow(() -> new RuntimeException("Video not found!"));
        videoRepository.delete(video);
        auditService.logAction("REMOVE", title, "Video removed successfully");
    }
    
    public Video rentVideo(String title) {
        Video video = videoRepository.findByTitleIgnoreCase(title)
            .orElseThrow(() -> new RuntimeException("Video not found!"));
        
        if (video.isRented()) {
            throw new RuntimeException("Video is already rented!");
        }
        
        video.setRented(true);
        Video updated = videoRepository.save(video);
        auditService.logAction("RENT", title, "Video rented successfully");
        return updated;
    }
    
    public Video returnVideo(String title) {
        Video video = videoRepository.findByTitleIgnoreCase(title)
            .orElseThrow(() -> new RuntimeException("Video not found!"));
        
        if (!video.isRented()) {
            throw new RuntimeException("Video was not rented!");
        }
        
        video.setRented(false);
        Video updated = videoRepository.save(video);
        auditService.logAction("RETURN", title, "Video returned successfully");
        return updated;
    }
    
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    
    public Video getVideo(String title) {
        return videoRepository.findByTitleIgnoreCase(title)
            .orElseThrow(() -> new RuntimeException("Video not found!"));
    }
}
