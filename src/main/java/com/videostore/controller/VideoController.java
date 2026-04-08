package com.videostore.controller;

import com.videostore.model.Video;
import com.videostore.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "*")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addVideo(@RequestBody Map<String, String> request) {
        try {
            Video video = videoService.addVideo(request.get("title"));
            return ResponseEntity.ok(video);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    @PostMapping("/remove")
    public ResponseEntity<?> removeVideo(@RequestBody Map<String, String> request) {
        try {
            videoService.removeVideo(request.get("title"));
            Map<String, String> response = new HashMap<>();
            response.put("message", "Video removed successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    @PostMapping("/rent")
    public ResponseEntity<?> rentVideo(@RequestBody Map<String, String> request) {
        try {
            Video video = videoService.rentVideo(request.get("title"));
            return ResponseEntity.ok(video);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
    
    @PostMapping("/return")
    public ResponseEntity<?> returnVideo(@RequestBody Map<String, String> request) {
        try {
            Video video = videoService.returnVideo(request.get("title"));
            return ResponseEntity.ok(video);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
