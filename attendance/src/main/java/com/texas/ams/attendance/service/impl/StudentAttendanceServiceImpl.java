package com.texas.ams.attendance.service.impl;

import com.texas.ams.attendance.dto.AttendanceRequestDto;
import com.texas.ams.attendance.model.Student;
import com.texas.ams.attendance.model.StudentAttendance;
import com.texas.ams.attendance.repo.AttendanceReportRepo;
import com.texas.ams.attendance.repo.StudentRepo;
import com.texas.ams.attendance.service.StudentAttendanceService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAttendanceServiceImpl implements StudentAttendanceService {
    private final AttendanceReportRepo attendanceReportRepo;
    private final StudentRepo studentRepo;

    public StudentAttendanceServiceImpl(AttendanceReportRepo attendanceReportRepo, StudentRepo studentRepo) {
        this.attendanceReportRepo = attendanceReportRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public Integer doAttendance(AttendanceRequestDto attendanceRequestDto) {
        List<Integer> presentStudentIdList = attendanceRequestDto.getStudentIds();

        List<StudentAttendance> presentStudentAttendaceList= presentStudentIdList.stream()
                .map(studentId->{
                    Student student = studentRepo.findById(studentId).orElseThrow(
                            () -> new RuntimeException("Student Not Found")
                    );
                    StudentAttendance studentAttendance=new StudentAttendance();
                    studentAttendance.setStudent(student);
                    studentAttendance.setAttendanceDate(LocalDate.now());
                    studentAttendance.setAttendanceStatus(AttendanceStatus.PRESENT);
                    return studentAttendance;
                }).collect(Collectors.toList());
        attendanceReportRepo.saveAll(presentStudentAttendaceList);
        return 1;
    }

    }
}
