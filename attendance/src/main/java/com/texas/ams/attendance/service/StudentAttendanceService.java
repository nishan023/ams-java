package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.AttendanceRequestDto;

public interface StudentAttendanceService {
    Integer doAttendance(AttendanceRequestDto attendanceRequestDto);
}
