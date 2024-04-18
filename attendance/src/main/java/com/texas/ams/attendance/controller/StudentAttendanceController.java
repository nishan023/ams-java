package com.texas.ams.attendance.controller;

import com.texas.ams.attendance.dto.AttendanceRequestDto;
import com.texas.ams.attendance.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

public class StudentAttendanceController {
    @RestController
    @RequestMapping("/api/student-attendance")
    public class StudentAttendanceController {
        private final StudentAttendanceService studentAttendanceService;
@Autowired
        public StudentAttendanceController(StudentAttendanceService studentAttendanceService) {
            this.studentAttendanceService = studentAttendanceService;
        }


        @PostMapping("/save")
        public ResponseEntity saveStudent(@RequestBody AttendanceRequestDto attendanceRequestDto) {
            Integer data = studentAttendanceService.doAttendance(attendanceRequestDto);
            return ResponseEntity.ok(
                    Map.of("message", "Attendance done Successfully.")
            );
        }

    }
}
