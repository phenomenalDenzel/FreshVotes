package com.freshvotes.service.mapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.freshvotes.model.Authority;
import com.freshvotes.model.User;
import com.freshvotes.repository.AuthorityRepository;
import com.freshvotes.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements EntityMapper<UserDTO, User> {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public User toEntity(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        Set<Authority> authorities = dto.getAuthorities().stream()
                                        .map(authorityRepository::findById)
                                        .filter(Optional::isPresent)
                                        .map(Optional::get)
                                        .collect(Collectors.toSet());
        user.setAuthorities(authorities);
        return user;
    }

    @Override
    public UserDTO toDto(User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setAuthorities(entity.getAuthorities().stream()
                          .map(authority -> authority.getAuthority())
                          .collect(Collectors.toSet()));
        return dto;
    }


}
