package com.practice.rolesecurity.controller;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/details")
    public List<RegisterEntity> details(){
        return userService.userDetails();
    }

}
