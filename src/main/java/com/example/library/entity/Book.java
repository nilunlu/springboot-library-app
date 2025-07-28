package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data//Getter, Setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id//Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int stock; // Kitap stok adedi

    @ManyToOne
    private Category category;// Her kitap sadece bir kategoriye ait

    @ManyToMany
    private List<Author> authors;//Kitabın birden çok yazarı olabilir, aynı yazar başka kitaplara da yazmış olabilir.

    @OneToMany(mappedBy = "book") // Bu kitapla ilgili ödünç kayıtları
    private List<Loan> loans;
}
