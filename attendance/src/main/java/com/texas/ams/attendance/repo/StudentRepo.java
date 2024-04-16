package com.texas.ams.attendance.repo;

import com.texas.ams.attendance.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}

