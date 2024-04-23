package com.texas.ams.attendance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDto {

    public int id;

    @NotNull(message = "name is mandatory")
    @NotEmpty(message = "name cannot be blank")
    public String name;
    @NotNull(message = "facuty is mandatory")
    public String faculty;

    @NotNull(message = "semster is mandatory")
    public String semester;
    @NotNull(message = "email is mandatory")
    public String email;
    @NotNull(message = "address is mandatory")
    public String address;
    @NotNull(message = "contact is mandatory")
    public String contact;

    public StudentDto(int id, String name, String faculty, String semester, String email, String address, String contact) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.semester = semester;
        this.email = email;
        this.address = address;
        this.contact = contact;
    }

    public StudentDto(String name, String faculty, String semester, String email, String address, String contact) {
        this.name = name;
        this.faculty = faculty;
        this.semester = semester;
        this.email = email;
        this.address = address;
        this.contact = contact;
    }

    public StudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
