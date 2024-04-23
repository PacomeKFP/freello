package org.enspy.freello.services;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.Project;
import org.enspy.freello.models.Task;
import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateTaskDto;
import org.enspy.freello.repositories.TaskRepository;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findOne(UUID id){
        return taskRepository.findById(id);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task add(CreateTaskDto createTaskDto, Project project){
        Task task = new Task();
        Date date = new Date(System.currentTimeMillis());
        task.setTitle(createTaskDto.getTitle());
        task.setDescription(createTaskDto.getDescription());
        task.setStatus(null);
        task.setProjet(project);
        task.setCreatedAt(date);
        task.getCollaborators().add(createTaskDto.getProjectAsProject().getAdmin());

        return taskRepository.save(task);
    }

    public Optional<Task> update(UUID id, CreateTaskDto createTaskDto){
        Optional<Task> taskOpt = taskRepository.findById(id);
        if(taskOpt.isPresent()){
            Task task = taskOpt.get();
            task.setTitle(createTaskDto.getTitle());
            task.setDescription(createTaskDto.getDescription());
            taskRepository.save(task);
        }
        return taskOpt;
    }

    public void delete(UUID id){
        taskRepository.deleteById(id);
    }
    //ajout de membres au projet
    public Task addCollaboratorTask(UUID taskId, UUID collaboratorId) {
        // Récupération du projet et du membre par leurs ID
        Task tasks = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));
        User collaborator = userRepository.findById(collaboratorId)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        
        // Ajouter le membre au projet
        tasks.getCollaborators().add(collaborator);
        
        // Envoyer une notification au membre ajouté
        notificationService.notify(collaborator, "Vous avez été assigné à la tâche : " + tasks.getTitle());
        
        // Enregistrement des modifications dans la base de données
        return taskRepository.save(tasks);
    }
}
