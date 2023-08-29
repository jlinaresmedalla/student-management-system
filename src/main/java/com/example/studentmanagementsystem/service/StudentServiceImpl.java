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
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map((Student) -> new StudentDto(Student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        Student student = new Student(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return new StudentDto(student);
    }

    @Override
    public void updateStudentById(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
