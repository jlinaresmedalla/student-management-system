package com.example.studentmanagementsystem.entity;

import com.example.studentmanagementsystem.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;

    public Student(StudentDto studentDto) {
        this.firstName = studentDto.getFirstName();
        this.lastName = studentDto.getLastName();
        this.email = studentDto.getEmail();
    }

}
