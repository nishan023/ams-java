package com.texas.ams.attendance.model;

import com.texas.ams.attendance.enums.AttendanceStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="attendance_Sheet")
public class StudentAttendance {
    @Id
    @SequenceGenerator(name="atttendance_seq", sequenceName = "atttendance_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "atttendance_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate attendanceDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
}
