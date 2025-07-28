package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Otomatik artan primary anahtar
    private Long id;

    private String name;          // Kategori adı
}
