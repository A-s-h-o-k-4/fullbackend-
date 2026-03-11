package com.practice.rolesecurity.service;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(RegisterEntity data){
        List<RegisterEntity> check = registerRepository.findByEmail(data.getEmail());
        if(!check.isEmpty()){
            return "user already registered!..";
        }
        else{
            data.setPassword(passwordEncoder.encode(data.getPassword()));
            data.setRole("ROLE_USER");
            registerRepository.save(data);
            return "registered successfully...";
        }
    }


    public String loginUser(RegisterEntity data){
        List<RegisterEntity> user = registerRepository.findByEmail(data.getEmail());
        boolean check = passwordEncoder.matches(data.getPassword(), user.getFirst().getPassword());
        if(check){
            return jwtService.generateToken(user.getFirst().getEmail(), user.getFirst().getRole());
        }
        return "incorrect password!..";
    }



}
