package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id) {
        super("Student with ID " + id + " not found.");
    }
    
}
