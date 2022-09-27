package com.medvedev.usermanagement.utile;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationUtil {
    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{3,16}$");

    public static boolean validatePassword(String pass) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(pass);
        return matcher.find();
    }
}
