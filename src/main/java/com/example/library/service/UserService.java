package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. CREATE / UPDATE
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 2. READ (tek kullanıcı)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // 3. READ (tüm kullanıcılar)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 4. DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
