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

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<StudentDto> students = studentServiceImpl.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        //Student model object to store student form data
        StudentDto createdStudent = new StudentDto();
        model.addAttribute("student", createdStudent);
        return "create-student";
    }

    @PostMapping("/all")
    public String createStudent(@ModelAttribute("student") StudentDto student) {
        studentServiceImpl.addStudent(student);
        return "redirect:/api/v1/students/all";
    }





    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServiceImpl.getStudentById(id));
    }

    @PutMapping("/{id}")
    public String updateStudentById(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return "";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentServiceImpl.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

}
