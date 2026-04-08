package com.videostore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoRentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoRentalApplication.class, args);
        System.out.println("Video Rental Store Application Started!");
        System.out.println("Access at: http://localhost:8080");
    }
}
