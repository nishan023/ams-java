package com.texas.ams.attendance.dto;

import java.util.List;

public class AttendanceRequestDto {
    private List<Integer> studentIds;

    public AttendanceRequestDto(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public AttendanceRequestDto() {
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
