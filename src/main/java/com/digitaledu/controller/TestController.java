package com.digitaledu.controller;

import com.digitaledu.repository.LecturerRepository;
import com.digitaledu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping
    public void call(){
        System.out.println("Here");
    }

}
