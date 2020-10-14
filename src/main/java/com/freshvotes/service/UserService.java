package com.freshvotes.service;

import com.freshvotes.model.User;
import com.freshvotes.repository.UserRepository;
import com.freshvotes.service.dto.UserDTO;
import com.freshvotes.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class   UserService {

    private final UserMapper userMapper;

    private UserRepository userRepository;

    private PasswordEncoder encoder;

    public UserService(UserMapper userMapper, UserRepository userRepository,PasswordEncoder encoder){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public UserDTO save(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
