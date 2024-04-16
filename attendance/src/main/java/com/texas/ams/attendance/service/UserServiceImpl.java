package com.texas.ams.attendance.service;

import com.texas.ams.attendance.dto.UserDto;
import com.texas.ams.attendance.model.User;
import org.springframework.stereotype.Service;
import com.texas.ams.attendance.repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getPassword());
        } else {
            throw new RuntimeException("User Not Found");
        }
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream()
                .map(user -> new UserDto(user.getUsername(), user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User Not Found");
        }
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User Not Found");
        }
    }
}
