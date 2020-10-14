package com.freshvotes.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.freshvotes.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomSecurityUser implements UserDetails{
    private static final long serialVersionUID = -8351482943638214015L;
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    public CustomSecurityUser(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = user.getAuthorities().stream()
                                            .map(authority->authority.getAuthority())
                                            .map(SimpleGrantedAuthority::new)
                                            .collect(Collectors.toSet());
    }

    public CustomSecurityUser(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
