package com.practice.rolesecurity.controller;

import com.practice.rolesecurity.entity.RegisterEntity;
import com.practice.rolesecurity.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/info")
    public List<RegisterEntity> userInfo(){
        return adminService.readUser();
    }

    @PutMapping("/edit")
    public RegisterEntity userEdit(@RequestParam Long id,@RequestBody RegisterEntity data){
        return adminService.editUser(id, data);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Long id){
        return adminService.deleteUser(id);
    }
}
