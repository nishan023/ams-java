package com.texas.ams.attendance.service.impl;

import com.texas.ams.attendance.dto.UserDto;
import com.texas.ams.attendance.model.User;
import com.texas.ams.attendance.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.texas.ams.attendance.repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo,PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        String plainPassword=userDto.getPassword();
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);
        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getPassword(),user.getRole());
        } else {
            throw new RuntimeException("User Not Found");
        }
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream()
                .map(user -> new UserDto(user.getUsername(), user.getId(), user.getUsername(),user.getRole()))
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
