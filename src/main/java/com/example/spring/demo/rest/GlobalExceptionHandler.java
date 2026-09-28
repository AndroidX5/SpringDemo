package com.example.spring.demo.rest;

import com.example.spring.demo.entity.StudentNotFoundErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleException(StudentNotFountException ex) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleException(Exception ex) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
