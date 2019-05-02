package com.digitaledu.bootstrap;

import com.digitaledu.model.*;
import com.digitaledu.repository.*;
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
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("APPLICATION LOADED, FILLING WITH SEED DATA");

        List<Users> usersList = new ArrayList<>();

        for(int i = 1; i <= 20; i++){
            usersList.add(Users.builder()
                    .username("user"+i)
                    .password("123")
                    .fullName("Demo User "+i)
                    .active(true)
                    .build()
            );
        }
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

        List<Role> roleList = new ArrayList<>();

        roleList.add(Role.builder().name("SUPER_ADMIN").build());
        roleList.add(Role.builder().name("MODERATOR").build());

        roleRepository.saveAll(roleList);


        List<Permission> permissionList = new ArrayList<>();

        permissionList.add(Permission.builder().name("CAN_CREATE").build());
        permissionList.add(Permission.builder().name("CAN_EDIT").build());
        permissionList.add(Permission.builder().name("CAN_DELETE").build());

        permissionRepository.saveAll(permissionList);

    }


}
