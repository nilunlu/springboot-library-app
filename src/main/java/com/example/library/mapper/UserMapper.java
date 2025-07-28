package com.example.library.mapper;

import com.example.library.dto.UserDTO;
import com.example.library.entity.User;

public class UserMapper {
    // Entity → DTO
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getFullName());
    }

    // DTO → Entity
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());// DTOdan ID al
        user.setFullName(dto.getFullName());// DTOdan isim al
        return user;
    }
}
