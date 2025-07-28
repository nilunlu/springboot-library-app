//http://localhost:8080/h2-console
package com.example.library.config;

import com.example.library.entity.*;
import com.example.library.repository.*;
import com.example.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepo,
                               BookRepository bookRepo,
                               AuthorRepository authorRepo,
                               CategoryRepository categoryRepo,
                               LoanRepository loanRepository,
                               BookService bookService) {

        return args -> {
            // Kullanıcılar
            User user1 = new User(null, "Ahmet", null);
            user1 = userRepo.save(user1);
            User user2 = new User(null, "nil", null);
            user2 = userRepo.save(user2);

            // Kategori
            Category cat1 = new Category(null, "Roman");
            cat1 = categoryRepo.save(cat1);

            Category cat2 = new Category(null,"bilgisayar");
            cat2 = categoryRepo.save(cat2);

            Category cat5 = new Category(null, "Koridor Yayıncılık");
            cat5 = categoryRepo.save(cat5);

            // Yazarlar
            Author a1 = new Author(null, "Orhan Pamuk", null);
            a1 = authorRepo.save(a1);
            Author a2 = new Author(null, "Niloram", null);
            a2 = authorRepo.save(a2);
            Author a5 = new Author(null, "Vittorio Hösle-Nora K", null);
            a5 = authorRepo.save(a5);

            // Kitaplar
            Book b1 = new Book();
            b1.setTitle("Kırmızı Saçlı Kadın");
            b1.setCategory(cat1);
            b1.setAuthors(List.of(a1));
            b1 = bookRepo.save(b1);
            b1.setStock(3); // kitap stoku 3 örnek

            Book b2 = new Book();
            b2.setTitle("Java ile Programlama");
            b2.setCategory(cat2);
            b2.setAuthors(List.of(a2));
            bookRepo.save(b2);

            Book b3 = new Book();
            b3.setTitle("Veri Yapıları");
            b3.setCategory(cat2);
            b3.setAuthors(List.of(a2));
            bookRepo.save(b3);

            Book b4 = new Book();
            b4.setTitle("bla Java veri bla");
            b4.setCategory(cat2);
            b4.setAuthors(List.of(a2));
            bookRepo.save(b4);

            Book b5 = new Book();
            b5.setTitle("Ölü Filozoflar Kahvesi");
            b5.setCategory(cat5);
            b5.setAuthors(List.of(a5));
            bookRepo.save(b5);


            // Ödünç
            Loan loan1 = new Loan();
            loan1.setUser(user1);
            loan1.setBook(b1);
            loan1.setLoanDate(LocalDate.now());
            loan1.setReturnDate(LocalDate.now().plusDays(14));
            loanRepository.save(loan1);

            System.out.println("🔁 Test verileri eklendi.");

            // Derived Query Testi
            System.out.println("🔍 Başlığında 'Java' geçen kitaplar:");
            bookService.searchBooksByTitle("Java").forEach(b ->
                    System.out.println(" - " + b.getTitle()));

            // PQL Query Testi
            System.out.println("📚 Kategorisi 'Roman' olan kitaplar:");
            bookService.getBooksByCategory("Roman").forEach(b ->
                    System.out.println(" - " + b.getTitle()));

            //native Query Testi
            System.out.println("🧵 Native SQL ile başlıkta 'veri' geçen kitaplar:");
            bookService.searchBooksNative("veri").forEach(b ->
                    System.out.println(" - " + b.getTitle()));
        };
    }
}
