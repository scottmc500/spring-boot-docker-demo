package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teacher;
import com.example.demo.exception.TeacherNotFoundException;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {
    @Autowired private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(int id, Teacher teacherDetails) {
        return teacherRepository.findById(id).map(t -> {
            t.setName(teacherDetails.getName());
            t.setEmail(teacherDetails.getEmail());
            t.setAddress(teacherDetails.getAddress());
            t.setPhone(teacherDetails.getPhone());
            t.setBirthDate(teacherDetails.getBirthDate());
            t.setCourses(teacherDetails.getCourses());
            return teacherRepository.save(t);
        }).orElseThrow(() -> new TeacherNotFoundException(id));
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
