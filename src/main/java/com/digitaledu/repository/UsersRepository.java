package com.digitaledu.repository;


import com.digitaledu.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    // SELECT * FROM user WHERE username = ? LIMIT 1
    Users findByUsername(String username);

    // SELECT * FROM user WHERE username = ? and active = ? LIMIT 1
    Users findByUsernameAndActive(String username, boolean active);


    // SELECT * FROM user WHERE active = ?
    List<Users> findByActive(boolean active);

}
