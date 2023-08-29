package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.dto.StudentDto;
import com.example.studentmanagementsystem.service.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
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
    public String createStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "create-student";
        }
        studentServiceImpl.addStudent(student);
        return "redirect:/api/v1/students/all";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
          StudentDto student = studentServiceImpl.getStudentById(id);
          model.addAttribute("student", student);
          return "edit-student";
    }

    @PostMapping ("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "edit-student";
        }
        studentServiceImpl.updateStudentById(id, student);
        return "redirect:/api/v1/students/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentServiceImpl.deleteStudentById(id);
        return "redirect:/api/v1/students/all";
    }

    @GetMapping("/view/{id}")
    public String viewStudentById(@PathVariable Long id, Model model) {
        StudentDto student = studentServiceImpl.getStudentById(id);
        model.addAttribute("student", student);
        return "view-student";
    }
}
