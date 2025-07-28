// yazarlarla ilgili tüm CRUD işlemlerini yönetimi
package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    // 1. Tüm yazarları getir
    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    // 2. ID ile yazar getir
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorRepo.findById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Yeni yazar oluştur
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    // 4. Yazar güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authorRepo.findById(id)
                .map(author -> {
                    author.setFullName(updatedAuthor.getFullName());
                    return ResponseEntity.ok(authorRepo.save(author));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Yazar sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
