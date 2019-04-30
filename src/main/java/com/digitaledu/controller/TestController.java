package com.digitaledu.controller;

import com.digitaledu.wrapper.LecturerWrapper;
import com.digitaledu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<LecturerWrapper> call() {
        return lectureService.lecturerDTOList();
    }

}
