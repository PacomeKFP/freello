package org.enspy.freelo.controllers;

import org.enspy.freelo.models.User;
import org.enspy.freelo.services.UserService;
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
    // create a new user
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


    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

}
