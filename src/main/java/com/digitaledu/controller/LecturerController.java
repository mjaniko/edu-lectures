package com.digitaledu.controller;

import com.digitaledu.data.dto.LecturerDTO;
import com.digitaledu.wrapper.LecturerWrapper;
import com.digitaledu.model.Lecturer;
import com.digitaledu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("lecturers")
public class LecturerController {

    @Autowired
    private LectureService lectureService;

    @PostMapping("add")
    public ResponseEntity addLecturer(@Valid @RequestBody LecturerDTO data){
        return lectureService.addLecturer(data);
    }


    @GetMapping("list")
    public List<Lecturer> list() {
        return lectureService.list();
    }

    @GetMapping("wrappedList")
    public List<LecturerWrapper> lecturerDTOList() {
        return lectureService.lecturerDTOList();
    }
}
