package com.videostore.service;

import com.videostore.model.Audit;
import com.videostore.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuditService {
    
    @Autowired
    private AuditRepository auditRepository;
    
    public void logAction(String actionType, String videoTitle, String details) {
        Audit audit = new Audit(actionType, videoTitle, details);
        auditRepository.save(audit);
    }
    
    public List<Audit> getAllLogs() {
        return auditRepository.findAllByOrderByTimestampDesc();
    }
}
