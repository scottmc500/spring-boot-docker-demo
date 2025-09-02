package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.TeacherNotFoundException;

@RestControllerAdvice
public class TeacherNotFoundHandler {
    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTeacherNotFound(TeacherNotFoundException ex) {
        return ex.getMessage();
    }
}
