package com.medvedev.usermanagement.dao;

import com.medvedev.usermanagement.model.Role;
import com.medvedev.usermanagement.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Vladimir Medvedev 15.08.2019
 */
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final UserDataJpa repository;

    @Override
    public UserEntity save(UserEntity user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public List<UserEntity> getAllbyUserRole(Role role) {
        return repository.getAllByRole(role);
    }

    @Override
    public UserEntity getByUserName(String name) {
        return repository.getByUsername(name);
    }

    @Override
    public List<UserEntity> filterByUserName(String name) {
        return repository.filterByUsername(name);
    }

    @Override
    public Page<UserEntity> getUsersPage(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserEntity> filterByUserNameAndRole(String name, Role role) {
        return repository.filterByUsernameAndRole(role, name);
    }

    @Override
    public UserEntity get(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }
}
