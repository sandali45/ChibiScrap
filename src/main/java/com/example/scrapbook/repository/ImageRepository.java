package com.example.scrapbook.repository;

import com.example.scrapbook.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {}
