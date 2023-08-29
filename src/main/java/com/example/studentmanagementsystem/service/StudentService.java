package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void addStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    void updateStudentById(Long id, StudentDto studentDto);
    void deleteStudentById(Long id);

}
