package com.texas.ams.attendance.dto;

import com.texas.ams.attendance.enums.Role;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    public int id;
    @NotNull(message = "name is required")
    public String name;
    @NotNull(message = "username is required")
    public String username;
    @NotNull(message = "password is required")
    public String password;
    public Role role;

    public UserDto(int id, String name, String username, String password,Role role) {
        this.id = id;
this.role=role;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserDto(String name, String username,Role role) {
        this.name = name;
        this.username = username;
        this.role = role;

    }

    public UserDto(String username, int id, String name, Role role) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.role= role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
