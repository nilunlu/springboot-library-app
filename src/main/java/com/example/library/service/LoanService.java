package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.entity.Loan;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository; // ❗️eksikti

    public LoanService(LoanRepository loanRepository,
                       BookRepository bookRepository,
                       UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository; // ❗️ekle
    }

    @Transactional
    public void borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        if (book.getStock() <= 0) {
            throw new IllegalStateException("Kitap stokta yok");
        }

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(14)); // 2 hafta

        loanRepository.save(loan);

        book.setStock(book.getStock() - 1); // stok düş
        bookRepository.save(book);
    }

    @Transactional
    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Ödünç kaydı bulunamadı"));

        Book book = loan.getBook();
        book.setStock(book.getStock() + 1); // Kitap stokunu geri ekle
        bookRepository.save(book);

        loanRepository.delete(loan); // Loan kaydını sil
    }

    public double calculateLateFee(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Ödünç kaydı bulunamadı"));

        LocalDate today = LocalDate.now();
        LocalDate returnDate = loan.getReturnDate();

        if (today.isAfter(returnDate)) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(returnDate, today);
            double dailyFee = 2.0; // Gecikme başına günlük 2₺ ceza
            return daysLate * dailyFee;
        } else {
            return 0.0; // Gecikme yok
        }
    }




    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
