package com.practice.rolesecurity.controller;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterEntity data){
        return registerService.registerUser(data);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterEntity data){
        return registerService.loginUser(data);
    }
}
