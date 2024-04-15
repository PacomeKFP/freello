package org.enspy.freelo.services;

import lombok.Data;
import org.enspy.freelo.exception.ResourceNotFoundException;
import org.enspy.freelo.models.Task;
import org.enspy.freelo.models.User;
import org.enspy.freelo.models.dto.CreateTaskDto;
import org.enspy.freelo.repositories.TaskRepository;
import org.enspy.freelo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    public Task create(CreateTaskDto createTaskDto) {
        Task task = new Task(createTaskDto.getTitle(), createTaskDto.getDescription());
        return taskRepository.save(task);
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findOne(UUID id) {
        return taskRepository.findById(id);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(UUID id, Task taskDetails) {
        Task task =taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + id));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setWorkers(taskDetails.getWorkers());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(task);
    }
    public Task addCollaboratorToTask(UUID taskId, UUID userId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée pour cet id :: " + taskId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé pour cet id :: " + userId));

        task.getCollaborators().add(user);
        return taskRepository.save(task);
    }
}
