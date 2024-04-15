package org.enspy.freello.services;

import org.enspy.freello.exception.ResourceNotFoundException;
import org.enspy.freello.models.Users;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    // creer un nouvel utilisateur
    public Users saveUser(Users user){
        return userRepository.save(user);
    }
    // recuperer tous les utilisateurs
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    //recuperer un utilsateur par son ID
    public Optional<Users> findUserById(Long id){
        return userRepository.findById(id);
    }
    // Mettre a jour un utilisateur
    public Users updateUser(Long id, Users userDetails){
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé pour cet id :: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé pour cet id :: " + id));
        userRepository.delete(user);
    }
}
