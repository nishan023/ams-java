package com.texas.ams.attendance.repo;

import com.texas.ams.attendance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
