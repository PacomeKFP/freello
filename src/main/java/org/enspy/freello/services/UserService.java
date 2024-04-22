package org.enspy.freello.services;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.enspy.freello.models.Project;
import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateUserDto;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findOne(UUID id){
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Iterable<User> add(CreateUserDto createUserDto){
        User users = new User();
        users.setName(createUserDto.getName());
        users.setEmail(createUserDto.getEmail());
        users.setPassword(createUserDto.getPassword());

        userRepository.save(users);
        return userRepository.findAll();
    }

    public Optional<User> update(UUID id, CreateUserDto createUserDto){
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            user.setName(createUserDto.getName());
            user.setEmail(createUserDto.getEmail());
            userRepository.save(user);
        }
        return userOpt;
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }

    public Set<Project> getAllProjectsByUser(UUID userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        return user.getMemberProjects();
    }
}
