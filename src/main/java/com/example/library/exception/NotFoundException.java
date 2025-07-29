package com.example.library.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
//hata mesajnı üst sınıf RuntimeExceptiona  aktarır
