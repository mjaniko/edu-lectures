package com.digitaledu.wrapper;

public class StudentWrapper {
    private Long id;
    private String fullName;

    public StudentWrapper(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

}
