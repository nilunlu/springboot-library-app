package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "`user`") // çift tırnak değil, backtick (`) — AltGr + ,
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// ID otomatik artan olsun
    private String fullName;
    @OneToMany(mappedBy = "user")  // Bir kullanıcının birden fazla ödünç kaydı olabilir
    private List<Loan> loans;      // Loan sınıfı daha sonra yazılacak


}
