package com.texas.ams.attendance.dto;

import java.util.List;

public class AttendanceRequestDto {
//    private List<Integer> studentIds;
//
//    public AttendanceRequestDto(List<Integer> studentIds) {
//        this.studentIds = studentIds;
//    }
//
//    public AttendanceRequestDto() {
//    }
//
//    public List<Integer> getStudentIds() {
//        return studentIds;
//    }
//
//    public void setStudentIds(List<Integer> studentIds) {
//        this.studentIds = studentIds;
//    }

    private List<Integer> presentstudentIds;
    private List<Integer> absentstudentIds;

    public AttendanceRequestDto(List<Integer> studentIds, List<Integer> absentStudentIds) {
        this.presentstudentIds = studentIds;
        this.absentstudentIds = absentStudentIds;
    }

    public List<Integer> getAbsentStudentIds() {
        return absentstudentIds;
    }

    public void setAbsentStudentIds(List<Integer> absentStudentIds) {
        this.absentstudentIds = absentStudentIds;
    }

    public AttendanceRequestDto() {
    }

    public List<Integer> getPresentstudentIds() {
        return presentstudentIds;
    }

    public void setPresentstudentIds(List<Integer> studentIds) {
        this.presentstudentIds = studentIds;
    }

}
