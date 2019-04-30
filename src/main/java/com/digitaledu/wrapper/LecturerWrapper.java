package com.digitaledu.wrapper;


import java.util.List;

public class LecturerWrapper {

    private Long id;

    private List<StudentWrapper> student;

    private String fullName;

    public LecturerWrapper(Long id, List<StudentWrapper> student, String fullName) {
        this.id = id;
        this.student = student;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public List<StudentWrapper> getStudent() {
        return student;
    }

    public String getFullName() {
        return fullName;
    }
}
