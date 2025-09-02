package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.exception.CourseNotFoundException;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(int id, Course courseDetails) {
        return courseRepository.findById(id).map(course -> {
            course.setName(courseDetails.getName());
            course.setDescription(courseDetails.getDescription());
            course.setDepartment(courseDetails.getDepartment());
            course.setCredits(courseDetails.getCredits());
            course.setTeacher(courseDetails.getTeacher());
            course.setStudents(courseDetails.getStudents());
            return courseRepository.save(course);
        }).orElseThrow(() -> new CourseNotFoundException(id));
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
