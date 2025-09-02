package com.example.demo.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(int id) {
        super("Teacher with ID " + id + " not found.");
    }
}
