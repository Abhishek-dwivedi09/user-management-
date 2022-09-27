package com.medvedev.usermanagement.dao;
import com.medvedev.usermanagement.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final UserDataJpa repository;
    @Override
    public UserEntity save(UserEntity user) {
        return repository.saveAndFlush(user);
    }
    @Override
    public UserEntity getByUserName(String name) {
        return repository.getByUsername(name);
    }
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    @Override
    public UserEntity get(int id) {
        return repository.findById(id).get();
    }


}
