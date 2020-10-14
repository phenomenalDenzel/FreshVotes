package com.freshvotes.service;


import com.freshvotes.model.User;
import com.freshvotes.repository.UserRepository;
import com.freshvotes.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(()->new UsernameNotFoundException("Invalid " +
                                                                                 "username and " +
                                                                                 "password"));
        System.out.println("User=> "+user);
        return new CustomSecurityUser(user);
    }
}
