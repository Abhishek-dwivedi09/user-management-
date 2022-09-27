package com.medvedev.usermanagement.model;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    USER(0),
    ADMIN(1);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public static Role getRoleById(int value) {
        for (Role role : Role.values()) {
            if (role.getValue() == value)
                return role;
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
