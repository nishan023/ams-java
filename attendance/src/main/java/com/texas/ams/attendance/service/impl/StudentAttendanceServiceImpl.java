package com.texas.ams.attendance.service.impl;

import com.texas.ams.attendance.dto.AttendanceRequestDto;
import com.texas.ams.attendance.dto.AttendanceResponseDto;
import com.texas.ams.attendance.enums.AttendanceStatus;
import com.texas.ams.attendance.exception.StudentNotFoundException;
import com.texas.ams.attendance.model.Student;
import com.texas.ams.attendance.model.StudentAttendance;
import com.texas.ams.attendance.repo.AttendanceReportRepo;
import com.texas.ams.attendance.repo.StudentRepo;
import com.texas.ams.attendance.service.StudentAttendanceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
    private final AttendanceReportRepo attendanceReportRepo;
    private final StudentRepo studentRepo;

    public StudentAttendanceServiceImpl(AttendanceReportRepo attendanceReportRepo, StudentRepo studentRepo) {
        this.attendanceReportRepo = attendanceReportRepo;
        this.studentRepo = studentRepo;
    }

    @Override


    public Integer doAttendance(AttendanceRequestDto attendanceRequestDto) {
        List<Integer> presentStudentIdList = attendanceRequestDto.getPresentstudentIds();
        List<Integer> absentStudentIdList = attendanceRequestDto.getAbsentStudentIds();

        List<StudentAttendance> presentStudentAttendanceList = presentStudentIdList.stream()
                .map(studentId -> {
                    Student student = studentRepo.findById(studentId)
                            .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
                    StudentAttendance studentAttendance = new StudentAttendance();
                    studentAttendance.setStudent(student);
                    studentAttendance.setAttendanceDate(LocalDate.now());
                    studentAttendance.setAttendanceStatus(AttendanceStatus.PRESENT);
                    return studentAttendance;
                }).collect(Collectors.toList());

        List<StudentAttendance> absentStudentAttendanceList = absentStudentIdList.stream()
                .map(studentId -> {
                    Student student = studentRepo.findById(studentId)
                            .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
                    StudentAttendance studentAttendance = new StudentAttendance();
                    studentAttendance.setStudent(student);
                    studentAttendance.setAttendanceDate(LocalDate.now());
                    studentAttendance.setAttendanceStatus(AttendanceStatus.ABSENT);
                    return studentAttendance;
                }).collect(Collectors.toList());

        List<StudentAttendance> allAttendanceList = new ArrayList<>();
        allAttendanceList.addAll(presentStudentAttendanceList);
        allAttendanceList.addAll(absentStudentAttendanceList);

        attendanceReportRepo.saveAll(allAttendanceList);

        return allAttendanceList.size();
    }

//    public Integer doAttendance(AttendanceRequestDto attendanceRequestDto) {
//        List<Integer> presentStudentIdList = attendanceRequestDto.getPresentstudentIds();
//        List<Integer> absentStudentIdList = attendanceRequestDto.getAbsentStudentIds();
//        List<StudentAttendance> presentStudentAttendaceList = presentStudentIdList.stream()
//                .map(studentId -> {
//                    Student student = studentRepo.findById(studentId).orElseThrow(
//                            () -> new RuntimeException("Student Not Found")
//                    );
//                    StudentAttendance studentAttendance = new StudentAttendance();
//                    studentAttendance.setStudent(student);
//                    studentAttendance.setAttendanceDate(LocalDate.now());
//                    studentAttendance.setAttendanceStatus(AttendanceStatus.PRESENT);
//                    return studentAttendance;
//                }).collect(Collectors.toList());
//        attendanceReportRepo.saveAll(presentStudentAttendaceList);
//        return 1;
//
//
//        List<StudentAttendance> absentStudentAttendanceList = absentStudentIdList.stream()
//                .map(studentId -> {
//                    Student student = studentRepo.findById(studentId).orElseThrow(
//                            () -> new RuntimeException("Student Not Found")
//                    );
//                    StudentAttendance attendance = new StudentAttendance();
//                    attendance.setStudent(student);
//                    attendance.setAttendanceDate(LocalDate.now());
//                    attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
//                    return attendance;
//                }).collect(Collectors.toList());
//
//
//        List<StudentAttendance> allAttendanceList = new ArrayList<>();
//        allAttendanceList.addAll(presentStudentAttendaceList);
//        allAttendanceList.addAll(absentStudentAttendanceList);
//        AttendanceReportRepo.saveAll(allAttendanceList);
//        return allAttendanceList.size();
//
//
//
//
//}

    @Override
    public List<AttendanceResponseDto> getAttendanceListByDate(LocalDate date) {
        List<StudentAttendance> attendaceList = attendanceReportRepo.findAttendaceByDate(date);
        List<AttendanceResponseDto> dateWiseAttendaceList = attendaceList.stream()
                .map(attendance -> {
                    AttendanceResponseDto attendanceResponseDto = new AttendanceResponseDto(attendance.getStudent().getName(), date, attendance.getAttendanceStatus());
                    return attendanceResponseDto;
                }).collect(Collectors.toList());

        return dateWiseAttendaceList;
    }


}
