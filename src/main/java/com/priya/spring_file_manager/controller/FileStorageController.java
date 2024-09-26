package com.priya.spring_file_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.priya.spring_file_manager.dto.FileResponse;
import com.priya.spring_file_manager.service.FileStorageService;

@RestController
@RequestMapping("/api/files")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
        try {
            String fileId = fileStorageService.uploadFile(file);
            return new ResponseEntity<>("File uploaded successfully with id " + fileId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("File upload failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<?> retrieveFile(@PathVariable String id) {
        try {
        	FileResponse fileResponse = fileStorageService.retrieveFile(id);
            String fileName = fileResponse.getFileName();
            byte[] fileContent = fileResponse.getFileContent();
            
        	HttpHeaders headers = new HttpHeaders();
        	headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName); 
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>("File retrieval failed: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
