package com.digitaledu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class HomeController {

    // users/main
    @PostMapping("/main")
    public String index(){
        return "User main page";
    }

    @PostMapping("/profile")
    public String profile(){
        return "User Profile page";
    }

    @PutMapping("/put")
    public String setting(){
        return "User setting page";
    }


}
