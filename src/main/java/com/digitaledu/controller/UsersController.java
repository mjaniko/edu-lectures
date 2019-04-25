package com.digitaledu.controller;

import com.digitaledu.model.Lecturer;
import com.digitaledu.model.Users;
import com.digitaledu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;


    @PostMapping("/c")
    private Users create(@RequestBody Users userModel) {
        if (userModel != null && userModel.getId() == null) {
            usersRepository.save(userModel);
        }
        return null;
    }

    @PostMapping("/u")
    private Users update(@RequestBody Users userModel) {
        if (userModel != null && userModel.getId() != null) {
            if (usersRepository.findById(userModel.getId()).isPresent()) {
                usersRepository.save(userModel);
            }
            usersRepository.save(userModel);
        }
        return null;
    }

    @GetMapping("/r/{id}")
    private Users read(@PathVariable("id") Long id) {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()) {
            return usersOptional.get();
        }
        return null;
    }

    @PostMapping("/d")
    private boolean delete(@RequestBody Long id) {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()) {
            usersRepository.delete(usersOptional.get());
            return true;
        }
        return false;
    }

    @GetMapping("/printAll")
    private List<Users> printAll() {
        return (List<Users>) usersRepository.findAll();
    }


}
