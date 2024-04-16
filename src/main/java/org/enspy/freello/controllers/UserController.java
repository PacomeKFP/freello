package org.enspy.freello.controllers;

import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateUserDto;
import org.enspy.freello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findOne(@RequestParam UUID id){
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public Iterable<User> createUser(@RequestBody CreateUserDto createUserDto){
        return userService.add(createUserDto);
    }

    @PatchMapping("/users/{id}")
    public Optional<User> updateUser(@RequestParam UUID id, @RequestBody CreateUserDto createUserDto){
        return userService.update(id, createUserDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestParam UUID id){
        userService.delete(id);
    }
}