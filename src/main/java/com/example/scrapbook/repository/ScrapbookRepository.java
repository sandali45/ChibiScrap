package com.example.scrapbook.repository;

import com.example.scrapbook.model.Scrapbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapbookRepository extends JpaRepository<Scrapbook, Integer> {}
