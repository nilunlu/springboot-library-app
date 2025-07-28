package com.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;// kitap IDsi

    @NotBlank(message = "Kitap adı boş olamaz")
    @Size(min = 1, max = 200, message = "Kitap adı 1-200 karakter arası olmalı")
    private String title;

    @NotBlank(message = "Kategori adı boş olamaz")
    private String categoryName;// Entity yerine sadece ad bilgisi taşınır Book.category.name → BookDTO.categoryName
}
