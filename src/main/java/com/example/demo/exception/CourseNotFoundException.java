package com.example.demo.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(int id) {
        super("Course with ID " + id + " not found.");
    }
}
