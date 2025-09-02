package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student studentDetails) {
        return studentRepository.findById(id).map(s -> {
            s.setName(studentDetails.getName());
            s.setEmail(studentDetails.getEmail());
            s.setAddress(studentDetails.getAddress());
            s.setPhone(studentDetails.getPhone());
            s.setBirthDate(studentDetails.getBirthDate());
            s.setCourses(studentDetails.getCourses());
            return studentRepository.save(s);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
