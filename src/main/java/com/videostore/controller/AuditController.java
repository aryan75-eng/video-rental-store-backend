package com.videostore.controller;

import com.videostore.model.Audit;
import com.videostore.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audits")
@CrossOrigin(origins = "*")
public class AuditController {
    
    @Autowired
    private AuditService auditService;
    
    @GetMapping
    public List<Audit> getAllLogs() {
        return auditService.getAllLogs();
    }
}
