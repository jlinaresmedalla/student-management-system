package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto updateStudentById(Long id, StudentDto studentDto);
    void deleteStudentById(Long id);

}
