package com.medvedev.usermanagement.service;

import com.medvedev.usermanagement.dao.UserDao;
import com.medvedev.usermanagement.model.Role;
import com.medvedev.usermanagement.model.Status;
import com.medvedev.usermanagement.model.UserEntity;
import com.medvedev.usermanagement.utile.UserNotActiveException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    @Override
    public UserEntity getById(int id) {
        return userDao.get(id);
    }



    @Override
    public UserEntity save(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userDao.getByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
