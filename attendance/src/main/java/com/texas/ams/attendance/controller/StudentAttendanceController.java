package com.texas.ams.attendance.controller;

import com.texas.ams.attendance.dto.AttendanceRequestDto;
import com.texas.ams.attendance.dto.AttendanceResponseDto;
import com.texas.ams.attendance.service.StudentAttendanceService;
import com.texas.ams.attendance.service.impl.StudentAttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

        @GetMapping("/date/{attendanceDate}")
        public ResponseEntity fetchAttendace(@PathVariable("attendanceDate") LocalDate attendanceDate)
        {
            List<AttendanceResponseDto> data = studentAttendanceService.getAttendanceListByDate(attendanceDate);
            return ResponseEntity.ok(
                    Map.of("message","Attendance Fetched Successfully...","data",data)
            );
        }

    }
