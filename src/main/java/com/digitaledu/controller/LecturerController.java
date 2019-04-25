package com.digitaledu.controller;

import com.digitaledu.LecturerDTO;
import com.digitaledu.StudentDTO;
import com.digitaledu.model.Lecturer;
import com.digitaledu.model.Student;
import com.digitaledu.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lecturers")
public class LecturerController {

    @Autowired
    private LecturerRepository lecturerRepository;

    @GetMapping("list")
    public List<Lecturer> list(){
        return (List<Lecturer>) lecturerRepository.findAll();
    }

    @GetMapping("wrappedList")
    public List<LecturerDTO> lecturerDTOList(){
        List<LecturerDTO> dtos = new ArrayList<>();
        lecturerRepository.findAll().forEach((lecturer -> {

            List<StudentDTO> studentDTOList = new ArrayList<>();
            if(!lecturer.getStudent().isEmpty()){

                /**
                 * for(Student student : lecturer.getStudent()){
                    studentDTOList.add(new StudentDTO(student.getId(), student.getFullName()));
                } **/

                lecturer.getStudent().forEach(student -> {
                    studentDTOList.add(new StudentDTO(student.getId(), student.getFullName()));
                });
            }
            dtos.add(new LecturerDTO(lecturer.getId(), studentDTOList,  lecturer.getFullName()));
        }));

        return dtos;
    }
}
