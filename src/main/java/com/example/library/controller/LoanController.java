package com.example.library.controller;

import com.example.library.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // Kitap ödünç alma
    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        loanService.borrowBook(userId, bookId);
        return ResponseEntity.ok(" Kitap ödünç alındı");
    }

    // Kitap iade etme (loanId ile)
    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long loanId) {
        loanService.returnBook(loanId);
        return ResponseEntity.ok(" Kitap iade edildi");
    }
}
