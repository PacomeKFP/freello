package org.aku.freello.services;

import lombok.Data;
import org.aku.freello.models.User;
import org.aku.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(UUID id) {
        return userRepository.findById(id);
    }

    public User updateName(UUID id, String name) {
        User user = userRepository.getReferenceById(id);
        user.setName(name);
        return userRepository.save(user);
    }

    public User updatePassword(UUID id, String password) {
        User user = userRepository.getReferenceById(id);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
