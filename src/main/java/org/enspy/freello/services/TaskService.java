package org.enspy.freello.services;

import org.enspy.freello.exception.ResourceNotFoundException;
import org.enspy.freello.models.Tasks;
import org.enspy.freello.models.Users;
import org.enspy.freello.repositories.TaskRepository;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    // Créer une nouvelle tâche
    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }

    // Récupérer toutes les tâches
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par son ID
    public Tasks getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + id));
    }

    // Mettre à jour une tâche
    public Tasks updateTask(Long id, Tasks taskDetails) {
        Tasks task =taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + id));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setWorkers(taskDetails.getWorkers());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(task);
    }

    // Supprimer une tâche
    public void deleteTask(Long id) {
        Tasks task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + id));
        taskRepository.delete(task);
}
       //   Ajouter un collaborateur
    public Tasks addCollaboratorToTask(Long taskId, Long userId) {
        Tasks task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + taskId));
        Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé pour cet id :: " + userId));

        task.getCollaborators().add(user);
        return taskRepository.save(task);
    }

}
