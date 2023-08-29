package com.example.studentmanagementsystem.dto;

import com.example.studentmanagementsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public StudentDto(Student student) {
        this(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

}
