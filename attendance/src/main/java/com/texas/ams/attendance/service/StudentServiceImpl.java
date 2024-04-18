package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.StudentDto;
import com.texas.ams.attendance.model.Student;
import org.springframework.stereotype.Service;
import com.texas.ams.attendance.repo.StudentRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Integer save(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setFaculty(studentDto.getFaculty());
        student.setSemester(studentDto.getSemester());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setContact(studentDto.getContact());
        Student savedStudent = studentRepo.save(student);
        return savedStudent.getId();
    }

    @Override
    public StudentDto getById(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Student Not Found");
        } else {
            Student student = studentOptional.get();
            StudentDto studentDto = new StudentDto(
                    student.getId(), student.getName(), student.getFaculty(), student.getSemester(),
                    student.getEmail(), student.getAddress(), student.getContact()
            );
            return studentDto;
        }
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentList.stream()
                .map(student -> new StudentDto(
                        student.getId(), student.getName(), student.getFaculty(), student.getSemester(),
                        student.getEmail(), student.getAddress(), student.getContact()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Student Not Found");
        } else {
            studentRepo.deleteById(id);
        }
    }

    @Override
    public Student getStudent(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Student Not Found");
        } else {
            return studentOptional.get();
        }
    }

    @Override
    public void update(Integer id, StudentDto studentDto) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Student Not Found");
        } else {
            Student student = studentOptional.get();
            student.setName(studentDto.getName());
            student.setFaculty(studentDto.getFaculty());
            student.setSemester(studentDto.getSemester());
            student.setEmail(studentDto.getEmail());
            student.setAddress(studentDto.getAddress());
            student.setContact(studentDto.getContact());
            studentRepo.save(student);
        }
    }



}
