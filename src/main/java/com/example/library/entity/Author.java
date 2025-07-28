package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity//sınıf veritabanında bir tabloya karşılık gelir
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id // birincil anahtar
    @GeneratedValue(strategy = GenerationType.IDENTITY)// otomatik artan ID
    private Long id;
    private String fullName;
    @ManyToMany(mappedBy = "authors")
    @ToString.Exclude
    @JsonIgnore//sonsuz döngü hatasını engeller
    private List<Book> books;//yazarın yazdığı kitaplar listesi

}
