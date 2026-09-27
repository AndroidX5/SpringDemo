package com.example.spring.demo.rest;

public class StudentNotFountException extends RuntimeException {
    public StudentNotFountException(String message) {
        super(message);
    }

    public StudentNotFountException() {
    }

    public StudentNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFountException(Throwable cause) {
        super(cause);
    }

    public StudentNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
