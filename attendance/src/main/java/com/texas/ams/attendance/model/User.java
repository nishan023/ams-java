package com.texas.ams.attendance.model;

import com.texas.ams.attendance.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(name="name",nullable=false)
    public String name;
    @Column(name="username",nullable=false)
    public String username;
    @Column(name="password",nullable=false)
    public String password;
    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    public Role role;


    public User(int id, String name, String username, String password, Role role) {
        this.id = id;
        this.name = name;
        this.role=role;
        this.username = username;
        this.password = password;

    }

    public User(String name, String username, String password, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role=role;

    }
    public User() {}

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
