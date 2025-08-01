package com.example.scrapbook.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Scrapbooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scrapbook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Lob
    private String layoutJson;

    @ManyToOne @JoinColumn(name="userId")
    private User user;
}
