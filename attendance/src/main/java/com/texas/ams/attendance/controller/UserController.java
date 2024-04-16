package com.texas.ams.attendance.controller;

import com.texas.ams.attendance.dto.UserDto;
import com.texas.ams.attendance.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.texas.ams.attendance.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        Integer userId = userService.save(userDto);
        return ResponseEntity.ok(
                Map.of("message", "User saved successfully.", "userId", userId)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Integer id) {
        UserDto userDto = userService.getById(id);
        return ResponseEntity.ok(
                Map.of("message", "User fetched successfully.", "data", userDto)
        );
    }

    @GetMapping("/list")
    public ResponseEntity fetchAllUsers() {
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.ok(
                Map.of("message", "User list fetched successfully.", "data", userDtoList)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok(
                Map.of("message", "User deleted successfully.")
        );
    }

    @GetMapping("/userid/{id}")
    public ResponseEntity fetchUserEntityById(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(
                Map.of("message", "User entity fetched successfully.", "data", user)
        );
    }
}
