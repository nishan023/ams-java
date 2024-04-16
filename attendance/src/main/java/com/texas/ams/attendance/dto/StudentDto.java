package com.texas.ams.attendance.dto;

public class StudentDto {

    public int id;
    public String name;
    public String faculty;
    public String semester;
    public String email;
    public String address;
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
