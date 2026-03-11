package com.practice.rolesecurity.service;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping("/details")
    public List<RegisterEntity> userDetails(){
        return registerRepository.findAll();
    }

}
