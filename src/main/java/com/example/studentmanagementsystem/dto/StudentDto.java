package com.example.studentmanagementsystem.dto;

import com.example.studentmanagementsystem.entity.Student;

public record StudentDto(Long id, String firstName, String lastName, String email) {

    public StudentDto(Student student) {
        this(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

}
