package com.texas.ams.attendance.dto;

import com.texas.ams.attendance.enums.AttendanceStatus;

import java.time.LocalDate;

public class AttendanceResponseDto {

    private String studentName;

    private LocalDate date;

    private AttendanceStatus status;

    public AttendanceResponseDto(String studentName, LocalDate date, AttendanceStatus status) {
        this.studentName = studentName;
        this.date = date;
        this.status = status;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
