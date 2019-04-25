package com.digitaledu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "lecturer")
public class Lecturer extends AbstractEntity{


    @OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<Student> student;

    @Column(name = "full_name")
    private String fullName;

}
