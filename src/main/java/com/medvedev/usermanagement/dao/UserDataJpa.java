package com.medvedev.usermanagement.dao;

import com.medvedev.usermanagement.model.Role;
import com.medvedev.usermanagement.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by Vladimir Medvedev 15.08.2019
 */
public interface UserDataJpa extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> getAllByRole(Role role);

    UserEntity getByUsername(String name);

    @Query("SELECT user from UserEntity user WHERE user.username LIKE CONCAT('%',:name,'%') ")
    List<UserEntity> filterByUsername(@Param("name") String name);

    @Query("SELECT user from UserEntity user WHERE user.role=:role and user.username LIKE CONCAT('%',:name,'%') ")
    List<UserEntity> filterByUsernameAndRole(@Param("role") Role role, @Param("name") String name);
}
