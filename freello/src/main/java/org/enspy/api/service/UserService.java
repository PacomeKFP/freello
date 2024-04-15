
package org.enspy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import org.enspy.api.model.*;
import org.enspy.api.repository.*;

import lombok.Data;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<Users> getUser(final int id) {
        return userRepository.findById(id);
    }

    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(Users user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        throw new EntityNotFoundException("User with id " + user.getId() + " not found.");
    }
}