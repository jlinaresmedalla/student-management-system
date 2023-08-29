package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.StudentDto;
import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = new Student(studentDto);
        Student savedStudent = studentRepository.save(student);
        return new StudentDto(savedStudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map((Student) -> new StudentDto(Student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return new StudentDto(student);
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        Student updatedStudent = studentRepository.save(student);
        return new StudentDto(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
