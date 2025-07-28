package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Tüm kitapları getir
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // ID ile kitap getir
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return Optional.ofNullable(bookService.getBookById(id));
    }

    // Yeni kitap ekle
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // Kitap sil
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // 🔍 Başlıkta kelimeye göre ara (Derived Query)
    @GetMapping("/search")
    public List<Book> searchByTitle(@RequestParam String keyword) {
        return bookService.searchBooksByTitle(keyword);
    }

    // 📚 Kategori adına göre ara (JPQL)
    @GetMapping("/category")
    public List<Book> searchByCategory(@RequestParam String name) {
        return bookService.getBooksByCategory(name);
    }

    // 🧵 Native SQL ile başlık arama
    @GetMapping("/native")
    public List<Book> searchByNative(@RequestParam String keyword) {
        return bookService.searchBooksNative(keyword);
    }
}
