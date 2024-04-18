package com.texas.ams.attendance.repo;

import com.texas.ams.attendance.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceReportRepo extends JpaRepository<StudentAttendance,Integer> {
}
