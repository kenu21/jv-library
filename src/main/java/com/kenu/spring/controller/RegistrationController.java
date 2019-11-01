package com.kenu.spring.controller;

import com.kenu.spring.dto.UserRegistrationDto;
import com.kenu.spring.entity.User;
import com.kenu.spring.service.interfaces.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public String addUserPage() {
        return "registration";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid UserRegistrationDto user, BindingResult result) {
        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()),
                user.getFirstName(), user.getLastName(), user.getEmail());
        if (result.hasErrors()) {
            return "wrong";
        }
        userService.add(newUser);
        return "login";
    }
}
