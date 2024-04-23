package com.texas.ams.attendance.service;

import com.texas.ams.attendance.enums.Role;
import com.texas.ams.attendance.model.User;
import com.texas.ams.attendance.repo.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myBDUser=userRepo.findByUsername(username).orElseThrow(
                ()->new RuntimeException("Bad Credentials")

        );
        return new org.springframework.security.core.userdetails.User(
                myBDUser.getUsername(),
                myBDUser.getPassword(),
                getAuthorities(myBDUser.getRole())
        );
    }

    public  Set<SimpleGrantedAuthority> getAuthorities(Role role){
        Set<SimpleGrantedAuthority> roleSet = new HashSet<>();
        SimpleGrantedAuthority myRole = new SimpleGrantedAuthority("ROLE_" + role.name());
        roleSet.add(myRole);
        return roleSet;
    }


}
