package com.example.library.repository;

import com.example.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    // belirli bir kullanıcıya ait tüm ödünç kayıtları
    @Query("SELECT l FROM Loan l WHERE l.user.id = :userId")
    List<Loan> findByUserId(@Param("userId") Long userId);

    // yeslim tarihi geçmiş ödünçler olanlar
    @Query("SELECT l FROM Loan l WHERE l.returnDate < :today")
    List<Loan> findOverdueLoans(@Param("today") LocalDate today);

    //bir kitaba ait aktif ödünç kayıtları
    @Query("SELECT l FROM Loan l WHERE l.book.id = :bookId AND l.returnDate >= :today")
    List<Loan> findActiveLoansByBook(@Param("bookId") Long bookId, @Param("today") LocalDate today);
}
