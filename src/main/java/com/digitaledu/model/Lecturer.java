package com.digitaledu.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lecturer")
public class Lecturer extends AbstractEntity{


    @OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<Student> student;

    @Column(name = "full_name")
    private String fullName;

}
