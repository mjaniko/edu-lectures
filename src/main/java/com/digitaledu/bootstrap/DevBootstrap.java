package com.digitaledu.bootstrap;

import com.digitaledu.model.Users;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("APPLICATION LOADED, FILLING WITH SEED DATA");

        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("user1", "123", "Demo User 1", true));
        usersList.add(new Users("user2", "123", "Demo User 2", true));
        usersList.add(new Users("user3", "123", "Demo User 3", true));
        usersRepository.saveAll(usersList);


    }


}
