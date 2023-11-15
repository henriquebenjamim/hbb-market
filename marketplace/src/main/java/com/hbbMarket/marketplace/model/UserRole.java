package com.hbbMarket.marketplace.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum UserRole{

    ADMIN("role_admin"),
    USER("role_user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
