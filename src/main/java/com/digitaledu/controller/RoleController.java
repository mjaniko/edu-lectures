package com.digitaledu.controller;

import com.digitaledu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("list")
    public ResponseEntity roleList(){
        return ResponseEntity.ok(roleRepository.findAll());
    }

}
