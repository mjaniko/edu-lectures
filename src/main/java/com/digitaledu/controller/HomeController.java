package com.digitaledu.controller;

import com.digitaledu.configuration.CustomConfiguration;
import com.digitaledu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CustomConfiguration configuration;

    // users/main
    @GetMapping("/main")
    public String index(){
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
