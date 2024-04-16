package com.texas.ams.attendance.controller;

import com.texas.ams.attendance.dto.StudentDto;
import com.texas.ams.attendance.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.texas.ams.attendance.service.StudentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody StudentDto studentDto) {
        Integer studentId = studentService.save(studentDto);
        return ResponseEntity.ok(
                Map.of("message", "Student saved successfully.", "studentId", studentId)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity fetchStudentById(@PathVariable("id") Integer id) {
        StudentDto studentDto = studentService.getById(id);
        return ResponseEntity.ok(
                Map.of("message", "Student fetched successfully.", "data", studentDto)
        );
    }

    @GetMapping("/list")
    public ResponseEntity fetchAllStudents() {
        List<StudentDto> studentDtoList = studentService.getAll();
        return ResponseEntity.ok(
                Map.of("message", "Student list fetched successfully.", "data", studentDtoList)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.ok(
                Map.of("message", "Student deleted successfully.")
        );
    }

    @GetMapping("/student/{id}")
    public ResponseEntity fetchStudentEntityById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(
                Map.of("message", "Student entity fetched successfully.", "data", student)
        );
    }
}
