package com.example.studentmanagementsystem.dto;

import com.example.studentmanagementsystem.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    public StudentDto(Student student) {
        this(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

}
