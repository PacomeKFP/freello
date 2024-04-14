package org.aku.freello.controllers;


import org.aku.freello.models.User;
import org.aku.freello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> findOne(@PathVariable UUID id) {
        return userService.findOne(id);
    }

    @PatchMapping("{id}/name/{name}")
    public User updateName(@PathVariable UUID id, @PathVariable String name) {
        return userService.updateName(id, name);
    }

    @PatchMapping("{id}/password/{password}")
    public User updatePassword(@PathVariable UUID id, @PathVariable String password) {
        return userService.updatePassword(id, password);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
