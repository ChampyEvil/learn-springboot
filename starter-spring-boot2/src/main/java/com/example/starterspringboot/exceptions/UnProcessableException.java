package com.example.starterspringboot.exceptions;

public class UnProcessableException extends RuntimeException {
    public UnProcessableException(String message) {
        super(message);
    }
}
