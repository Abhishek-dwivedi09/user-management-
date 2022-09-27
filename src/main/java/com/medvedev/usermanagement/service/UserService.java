package com.medvedev.usermanagement.service;
import com.medvedev.usermanagement.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity getById(int id);
     UserEntity save(UserEntity user);
    void deleteUser(int id);
}
