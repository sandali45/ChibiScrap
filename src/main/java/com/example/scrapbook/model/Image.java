package com.example.scrapbook.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;

    @ManyToOne @JoinColumn(name="userId")
    private User user;
}
