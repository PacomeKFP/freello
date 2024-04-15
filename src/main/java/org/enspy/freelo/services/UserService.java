package org.enspy.freelo.services;

import lombok.Data;
import org.enspy.freelo.exception.ResourceNotFoundException;
import org.enspy.freelo.models.User;
import org.enspy.freelo.repositories.UserRepository;
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


    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findOne(UUID id) {
        return userRepository.findById(id);
    }
    public User updateUser(UUID id, User userDetails){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé pour cet id :: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }
}
