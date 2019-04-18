package com.digitaledu.controller;

import com.digitaledu.configuration.CustomConfiguration;
import com.digitaledu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class HomeController {

    @Autowired
    private CustomConfiguration configuration;

    @Autowired
    private UserRepository userRepository;

    // users/main
    @GetMapping("/main")
    public String index(){
        System.out.println(userRepository.getFirstName());
        return "index.html";
    }

    @PostMapping("/profile")
    public String profile(){
        configuration.getPrefix();
        return "User Profile page";
    }

    @PutMapping("/put")
    public String setting(){
        return "User setting page";
    }


    @GetMapping(value = "/r")
    public List<String> getOperation(){
        List<String> studentList = new ArrayList<>();
        studentList.add("MISHA");
        studentList.add("Achi");
        studentList.add("Gio");
        studentList.add("Nika");
        return studentList;
    }

}
