package com.digitaledu.controller;

import com.digitaledu.model.Student;
import com.digitaledu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("list")
    public List<Student> list(){
        return (List<Student>) studentRepository.findAll();
    }


}
