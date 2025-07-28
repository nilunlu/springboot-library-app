package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // // title içinde keyword geçen kitapları bulur
    List<Book> findByTitleContaining(String keyword);

    //JPQL: kategori adına göre kitaplar
    @Query("SELECT b FROM Book b WHERE b.category.name = :category")
    List<Book> findBooksByCategoryName(@Param("category") String categoryName);

    // 3. Native SQL: kitap adında geçen kelimeyle arama
    @Query(value = "SELECT * FROM book WHERE title LIKE %:keyword%", nativeQuery = true)
    List<Book> searchBooksNative(@Param("keyword") String keyword);


}
