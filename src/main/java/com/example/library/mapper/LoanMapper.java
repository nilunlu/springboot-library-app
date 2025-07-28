package com.example.library.mapper;

import com.example.library.dto.LoanDTO;
import com.example.library.entity.Loan;

public class LoanMapper {
    // Entity → DTO
    public static LoanDTO toDTO(Loan loan) {
        return new LoanDTO(
                loan.getId(),
                loan.getBook().getTitle(),
                loan.getUser().getFullName(),
                loan.getLoanDate(),
                loan.getReturnDate()
        );
    }
}
