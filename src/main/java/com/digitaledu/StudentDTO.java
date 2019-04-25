package com.digitaledu;

public class StudentDTO {
    private Long id;
    private String fullName;

    public StudentDTO(Long id, String fullName) {
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
