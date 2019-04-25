package com.digitaledu.bootstrap;

import com.digitaledu.model.Lecturer;
import com.digitaledu.model.Student;
import com.digitaledu.model.Users;
import com.digitaledu.repository.LecturerRepository;
import com.digitaledu.repository.StudentRepository;
import com.digitaledu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("APPLICATION LOADED, FILLING WITH SEED DATA");

        List<Users> usersList = new ArrayList<>();

        usersList.add(Users.builder()
                .username("user1")
                .password("123")
                .fullName("Demo User 1")
                .active(true)
                .build()
        );
        usersList.add(Users.builder()
                .username("user2")
                .password("123")
                .fullName("Demo User 2")
                .active(true)
                .build()
        );
        usersList.add(Users.builder()
                .username("user3")
                .password("123")
                .fullName("Demo User 3")
                .active(true)
                .build()
        );
        usersList.add(Users.builder()
                .username("user4")
                .password("124")
                .fullName("Demo User 4")
                .active(true)
                .build()
        );

        usersRepository.saveAll(usersList);


        List<Lecturer> lecturerList = new ArrayList<>();


        lecturerList.add(
                Lecturer.builder()
                .fullName("Giorgi Avaliani")
                .build()
        );
        lecturerList.add(Lecturer.builder().fullName("Mikheil Janiashvili").build());
        lecturerRepository.saveAll(lecturerList);

        List<Student> students = new ArrayList<>();

        students.add(Student.builder().fullName("Misho").build());
        students.add(Student.builder().fullName("Nika").build());
        students.add(Student.builder().fullName("Leqso").build());
        students.add(Student.builder().fullName("Achi").build());
        studentRepository.saveAll(students);


    }


}
