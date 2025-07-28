package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan birincil anahtar
    private Long id;

    private LocalDate loanDate;// Kitabın ödünç alındığı tarih
    private LocalDate returnDate;// Kitabın iade edilmesi gereken tarih

    @ManyToOne
    private User user;// Bir ödünç kaydı bir kullanıcıya aittir
    @ManyToOne
    private Book book; // Bir ödünç kaydı bir kitaba aittir



}
