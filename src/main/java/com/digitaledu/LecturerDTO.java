package com.digitaledu;


import java.util.List;

public class LecturerDTO {

    private Long id;

    private List<StudentDTO> student;

    private String fullName;

    public LecturerDTO(Long id, List<StudentDTO> student, String fullName) {
        this.id = id;
        this.student = student;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public List<StudentDTO> getStudent() {
        return student;
    }

    public String getFullName() {
        return fullName;
    }
}
