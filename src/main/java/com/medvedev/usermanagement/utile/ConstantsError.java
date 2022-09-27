package com.medvedev.usermanagement.utile;

import org.springframework.validation.FieldError;

public class ConstantsError {
    public static final FieldError PASSWORD_ERROR = new FieldError("userEntity", "password",
            "only latin characters. Minim 3, max 16, at least one char and one number");
    public static final FieldError USER_EXIST_ERROR = new FieldError("userEntity", "username", "user exist!");
}
