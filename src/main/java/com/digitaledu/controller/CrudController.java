package com.digitaledu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

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
