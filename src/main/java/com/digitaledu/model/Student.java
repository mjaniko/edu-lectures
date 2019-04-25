package com.digitaledu.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@Entity
@Table(name = "student")
public class Student extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @Column(name = "student_full_name")
    private String fullName;

}
