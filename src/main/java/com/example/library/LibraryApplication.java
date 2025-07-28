package com.example.library;

import org.springframework.boot.SpringApplication;//Spring Boot uygulamasını çalıştırmak için
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot:
// @Configuration: yapılandırma sınıfı
// @EnableAutoConfiguration: otomatik yapılandırma
// @ComponentScan: bileşenleri tarayıp yükler
@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        // Uygulama başlatılır, embedded Tomcat sunucusu çalışmaya başlar
        SpringApplication.run(LibraryApplication.class, args);//Spring Boot uygulamasını başlatır
    }

}
