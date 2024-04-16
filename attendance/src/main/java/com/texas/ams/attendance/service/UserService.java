package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.UserDto;
import com.texas.ams.attendance.model.User;

import java.util.List;

public interface UserService  {
    Integer save(UserDto userDto);
    UserDto getById(Integer id);

    List<UserDto> getAll();

    void deleteById(Integer id);

    User getUser(Integer id);
}
