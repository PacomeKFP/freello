package org.enspy.freello.controllers;

import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateUserDto;
import org.enspy.freello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findOne(@RequestParam UUID id) {
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        System.out.println("yo");
        return userService.add(createUserDto);
    }

    @PatchMapping("/users/{id}")
    public Optional<User> updateUser(@RequestParam UUID id, @RequestBody CreateUserDto createUserDto) {
        return userService.update(id, createUserDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestParam UUID id) {
        userService.delete(id);
    }
}
