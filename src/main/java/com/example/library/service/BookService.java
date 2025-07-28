package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.exception.NotFoundException;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 1. CREATE / UPDATE
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    // 3. READ (tüm kitaplar)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 4. DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> searchBooksByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return bookRepository.findBooksByCategoryName(categoryName);
    }

    public List<Book> searchBooksNative(String keyword) {
        return bookRepository.searchBooksNative(keyword);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kitap bulunamadı: " + id));
    }


}
