package com.freshvotes.service.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Set<String> authorities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(final Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + '}';
    }
}
