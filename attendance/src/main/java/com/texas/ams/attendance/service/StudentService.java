package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.StudentDto;
import com.texas.ams.attendance.model.Student;

import java.util.List;

public interface StudentService {
    Integer save(StudentDto studentDto);
    StudentDto getById(Integer id);

    List<StudentDto> getAll();

    void deleteById(Integer id);

    Student getStudent(Integer id);

    void update(Integer id, StudentDto studentDto);
}
