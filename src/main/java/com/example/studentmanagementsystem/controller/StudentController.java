package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.dto.StudentDto;
import com.example.studentmanagementsystem.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        StudentDto createdStudent = studentServiceImpl.addStudent(studentDto);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<StudentDto> students = studentServiceImpl.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServiceImpl.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentServiceImpl.updateStudentById(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentServiceImpl.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}
