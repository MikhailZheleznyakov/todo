package com.example.demo.SERVER.controllers;

import com.example.demo.SERVER.repository.UserRepository;
import com.example.demo.SERVER.tables.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    User addUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/getUser")
    User getUser(@PathVariable Long id){
        return this.userRepository.findUserById(id);
    }

    @GetMapping("/getUserAll")
    List<User> getUserAll(){
        return this.userRepository.findAll();
    }
}
