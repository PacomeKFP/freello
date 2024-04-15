package org.enspy.freello.controllers;


import org.enspy.freello.models.Users;
import org.enspy.freello.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    //creer une nouvel utilisateur
    @PostMapping("/")
    public Users createUser(@RequestBody Users user){
        return userService.saveUser(user);
    }
    // recuperer tous les utilisateurs
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
