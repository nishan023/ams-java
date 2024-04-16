package com.texas.ams.attendance.dto;

public class UserDto {
    public int id;
    public String name;

    public String username;

    public String password;

    public UserDto(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserDto(String name, String username) {
        this.name = name;
        this.username = username;

    }

    public UserDto(String username, int id, String name) {
        this.username = username;
        this.id = id;
        this.name = name;
    }

    public UserDto() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
