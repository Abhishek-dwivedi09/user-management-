package com.medvedev.usermanagement.dao;
import com.medvedev.usermanagement.model.UserEntity;

public interface UserDao {
    UserEntity save(UserEntity user);
    UserEntity get(int id);
    UserEntity getByUserName(String name);
    void delete(int id);
}
