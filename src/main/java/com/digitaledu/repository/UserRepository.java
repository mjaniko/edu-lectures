package com.digitaledu.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private String firstName = "Mikheil";

    public String getFirstName() {
        return firstName;
    }
}
