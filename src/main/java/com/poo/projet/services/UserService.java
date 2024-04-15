package com.poo.projet.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.User;
import com.poo.projet.models.require.UserRequire;
import com.poo.projet.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUser(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(UUID id){
        return userRepository.findById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void createUser(@Valid @ModelAttribute UserRequire userRequire){
        User users = new User();
        users.setName(userRequire.getName());
        users.setEmail(userRequire.getEmail());
        users.setPassword(userRequire.getPassword());
        
        userRepository.save(users);
    }

    public void updateUser(@RequestParam UUID id, @Valid @ModelAttribute UserRequire userRequire){
        Optional<User> users = userRepository.findById(id);

        users.get().setName(userRequire.getName());
        users.get().setEmail(userRequire.getEmail());

        userRepository.save(users.get());
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
}
