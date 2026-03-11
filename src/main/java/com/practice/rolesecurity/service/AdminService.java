package com.practice.rolesecurity.service;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<RegisterEntity> readUser(){
        return registerRepository.findAll();
    }

    public RegisterEntity editUser(Long id,RegisterEntity data){
        RegisterEntity user = registerRepository.findById(id).orElseThrow(()->new RuntimeException("id is not valid!.."));
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setRole(data.getRole());
        return registerRepository.save(user);
    }

    public String deleteUser(Long id){
        registerRepository.deleteById(id);
        return "Delete Successfully...";
    }
}
