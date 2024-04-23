package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.AttendanceRequestDto;
import com.texas.ams.attendance.dto.AttendanceResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface StudentAttendanceService {
    Integer doAttendance(AttendanceRequestDto attendanceRequestDto);
    List<AttendanceResponseDto> getAttendanceListByDate(LocalDate date);
}
