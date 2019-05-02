package com.digitaledu.controller;

import com.digitaledu.data.dto.UserDTO;
import com.digitaledu.data.mapper.UserMapper;
import com.digitaledu.model.Users;
import com.digitaledu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserMapper userMapper;

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
        return usersRepository.findAll();
    }

    @GetMapping("/printDtoAll")
    private List<UserDTO> printDtoAll() {
        return userMapper.mapList(usersRepository.findAll());
    }

    @GetMapping("/printFilterUser")
    private Page<Users> printFilterUser(@PageableDefault(value = 7) Pageable paginator ){
        return usersRepository.findAll(paginator);
    }





    @GetMapping("/findByUserName")
    private Users findByUserExampl(@RequestParam("name") String username) {
        return usersRepository.getUserName(username);
    }

    @GetMapping("/findByUserName2")
    private Long findByUserExampl2(@RequestParam("name") String username) {
        return usersRepository.getUserNamee(username);
    }

    @GetMapping("/setActivity")
    private ResponseEntity updateAllUserActivity(@RequestParam("active") boolean isActive){
        usersRepository.setAllUserActivityStatus(isActive);
        return ResponseEntity.ok(true);
    }

}
