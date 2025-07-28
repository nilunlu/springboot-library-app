package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Long id;

    // Optional validasyon: Boş olamaz
    private String bookTitle;

    private String userName;

    private LocalDate loanDate;

    private LocalDate returnDate;
}
