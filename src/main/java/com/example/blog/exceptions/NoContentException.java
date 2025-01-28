package com.example.blog.exceptions;

public class NoContentException extends RuntimeException {
    public NoContentException(String message) {
        super(message);
    }
}