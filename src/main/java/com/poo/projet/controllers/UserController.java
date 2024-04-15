package com.poo.projet.controllers;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poo.projet.models.User;
import com.poo.projet.models.require.UserRequire;
import com.poo.projet.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User>  showUser(){
        return userService.getUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> searchuser(@RequestParam UUID id){
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public Iterable<User> createUser(@RequestBody UserRequire userRequire){
        userService.createUser(userRequire);
        return userService.getUser();
    }

    @PatchMapping("/users/{id}")
    public Optional<User> updateUser(Model model, @RequestParam UUID id, @RequestBody UserRequire userRequire){
        userService.updateUser(id, userRequire);
        return userService.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestParam UUID id){
        userService.deleteUser(id);
    }

}
