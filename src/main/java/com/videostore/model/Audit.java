package com.videostore.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audits")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "action_type")
    private String actionType;
    
    @Column(name = "video_title")
    private String videoTitle;
    
    private String details;
    
    private LocalDateTime timestamp;
    
    public Audit() {}
    
    public Audit(String actionType, String videoTitle, String details) {
        this.actionType = actionType;
        this.videoTitle = videoTitle;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    
    public String getVideoTitle() { return videoTitle; }
    public void setVideoTitle(String videoTitle) { this.videoTitle = videoTitle; }
    
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
