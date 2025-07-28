package com.example.library.mapper;

import com.example.library.dto.BookDTO;
import com.example.library.entity.Book;

public class BookMapper {
    // Entity → DTO
    public static BookDTO toDTO(Book book) {
        //kategori adını al
        String categoryName = book.getCategory() != null ? book.getCategory().getName() : null;
        // yeni BookDTO nesnesi
        return new BookDTO(book.getId(), book.getTitle(), categoryName);
    }


    // DTO → Entity
    public static Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());// DTOdan ID al
        book.setTitle(dto.getTitle());// DTOdan title al
        // categoryName -> Category nesnesine dönüştürülmüyor çünkü Category entity lazım olur
        return book;
    }
}
