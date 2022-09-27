package com.medvedev.usermanagement.controller;

import com.medvedev.usermanagement.model.Role;
import com.medvedev.usermanagement.model.UserEntity;
import com.medvedev.usermanagement.service.UserService;
import com.medvedev.usermanagement.utile.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


import static com.medvedev.usermanagement.utile.ConstantsError.PASSWORD_ERROR;
import static com.medvedev.usermanagement.utile.ConstantsError.USER_EXIST_ERROR;

/**
 * created by Vladimir Medvedev 15.08.2019
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    @GetMapping("/{id}")
    public UserEntity getUser(Model model, @PathVariable int id) {
        UserEntity user = userService.getById(id);
        user.setPassword("");
        model.addAttribute("userEntity", user);
        return user;
    }
    @PostMapping("/save")
    public UserEntity newUser(@Valid UserEntity user, BindingResult bindingResult) {
        if (user.getId() == 0 && !ValidationUtil.validatePassword(user.getPassword())) {
            bindingResult.addError(PASSWORD_ERROR);
        }
        if (user.getId() > 0 && !user.getPassword().isEmpty()) {
            if (!ValidationUtil.validatePassword(user.getPassword())) {
                bindingResult.addError(PASSWORD_ERROR);
            }
        }

        if (!user.getPassword().isEmpty()) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        user.setCreated(LocalDateTime.now());
        userService.save(user);
        return user;
    }
    @DeleteMapping("/delete")
    public void deleteUser(Model model, @PathVariable int id){
        userService.deleteUser(id);

    }


}
