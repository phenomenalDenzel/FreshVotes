package com.freshvotes.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;

import com.freshvotes.security.AuthoritiesConstants;
import com.freshvotes.service.UserService;
import com.freshvotes.service.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService){this.userService = userService;}


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap model){
        model.put("user",new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String createAccount(UserDTO userDTO){
        userDTO.setAuthorities(new HashSet<>(Arrays.asList(AuthoritiesConstants.USER)));
        userService.save(userDTO);
        return "redirect:/login";
    }
}
