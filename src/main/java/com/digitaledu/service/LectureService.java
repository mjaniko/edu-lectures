package com.digitaledu.service;

import com.digitaledu.data.dto.LecturerDTO;
import com.digitaledu.data.dto.ResponseDTO;
import com.digitaledu.exception.DuplicateException;
import com.digitaledu.wrapper.StudentWrapper;
import com.digitaledu.wrapper.LecturerWrapper;
import com.digitaledu.model.Lecturer;
import com.digitaledu.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LecturerRepository lecturerRepository;

    public List<Lecturer> list() {
        return (List<Lecturer>) lecturerRepository.findAll();
    }

    public List<LecturerWrapper> lecturerDTOList() {
        List<LecturerWrapper> dtos = new ArrayList<>();
        lecturerRepository.findAll().forEach((lecturer -> {

            List<StudentWrapper> studentDTOList = new ArrayList<>();
            if (!lecturer.getStudent().isEmpty()) {

                /**
                 * for(Student student : lecturer.getStudent()){
                 studentDTOList.add(new StudentWrapper(student.getId(), student.getFullName()));
                 } **/

                lecturer.getStudent().forEach(student -> {
                    studentDTOList.add(new StudentWrapper(student.getId(), student.getFullName()));
                });
            }
            dtos.add(new LecturerWrapper(lecturer.getId(), studentDTOList, lecturer.getFullName()));
        }));

        return dtos;
    }

    public ResponseEntity addLecturer(LecturerDTO data) {
        // თუ მომხმარებელი არსებობს მაშინ სტატუსი არის false
        if (lecturerRepository.findByFullName(data.getName()) != null) {

            throw new DuplicateException("Lecturer already exists");

        }

        // თუ მომხმარებელი არსებობს მაშინ სტატუსი არის false
        Lecturer newLecturer = lecturerRepository.save(Lecturer
                .builder()
                .fullName(data.getName())
                .build());

        return ResponseEntity.ok(ResponseDTO.builder()
                .success(true)
                .content(newLecturer)
                .build());

    }
}
