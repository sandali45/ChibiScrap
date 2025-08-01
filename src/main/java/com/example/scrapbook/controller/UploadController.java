package com.example.scrapbook.controller;

import com.example.scrapbook.model.Image;
import com.example.scrapbook.model.Scrapbook;
import com.example.scrapbook.repository.ImageRepository;
import com.example.scrapbook.repository.ScrapbookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    private final ImageRepository imageRepo;
    private final ScrapbookRepository scrapbookRepo;

    public UploadController(ImageRepository imageRepo, ScrapbookRepository scrapbookRepo) {
        this.imageRepo = imageRepo;
        this.scrapbookRepo = scrapbookRepo;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        Path dir = Paths.get(uploadDir);
        if (!Files.exists(dir)) Files.createDirectories(dir);

        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = dir.resolve(filename);
        file.transferTo(filePath.toFile());

        Image img = new Image();
        img.setUrl("/" + uploadDir + "/" + filename);
        imageRepo.save(img);

        return ResponseEntity.ok(img.getUrl());
    }

    @PostMapping("/scrapbook")
    public ResponseEntity<String> saveScrapbook(@RequestBody Scrapbook scrapbook) {
        scrapbookRepo.save(scrapbook);
        return ResponseEntity.ok("Scrapbook saved!");
    }
}
