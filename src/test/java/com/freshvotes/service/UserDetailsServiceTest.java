package com.freshvotes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void generate_encrypted_password(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encryptedPassword = encoder.encode(rawPassword);
        System.out.println(encryptedPassword);
        assertThat(rawPassword).isNotEqualTo(encryptedPassword);
    }
}