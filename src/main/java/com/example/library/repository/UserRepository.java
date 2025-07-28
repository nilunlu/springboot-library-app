package com.example.library.repository;

import com.example.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// User nesnesi için CRUD işlemlerini sağlayan arayüz
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<Entity, ID tipi>
}
