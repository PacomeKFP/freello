package org.enspy.freello.services;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.enspy.freello.models.Project;
import org.enspy.freello.models.Task;
import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateProjectDto;
import org.enspy.freello.repositories.ProjectRepository;
import org.enspy.freello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }

    public Optional<Project> findOne(UUID id){
        return projectRepository.findById(id);
    }

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Project add(CreateProjectDto createProjectDto, User creator){

        Project projects = new Project();
        projects.setName(createProjectDto.getName());
        projects.setAdmin(creator);
        projects.getMembers().add(creator); // Ajouter le créateur aux membres du projet
        return projectRepository.save(projects);
    }

    public Optional<Project> update(UUID id, CreateProjectDto createProjectDto){
        Optional<Project> projectOpt = projectRepository.findById(id);
        if(projectOpt.isPresent()){
            Project project = projectOpt.get();
            project.setName(createProjectDto.getName());
            projectRepository.save(project);
        }
        return projectOpt;
    }

    public void delete(UUID id){
        projectRepository.deleteById(id);
    }

    //ajout de membres au projet
    public Project addMemberToProject(UUID projectId, UUID memberId) {
        // Récupération du projet et du membre par leurs ID
        Project projects = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé"));
        User member = userRepository.findById(memberId)
            .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
        
        // Ajouter le membre au projet
        projects.getMembers().add(member);
        
        // Envoyer une notification au membre ajouté
        notificationService.notify(member, "Vous avez été ajouté au projet : " + projects.getName());
        
        // Enregistrement des modifications dans la base de données
        return projectRepository.save(projects);
    }

    public Set<Task> getAllTasksByProject(UUID projectId) {
        // Trouver le projet par son ID
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("Projet non trouvé avec l'ID: " + projectId));
        
        // Retourner l'ensemble des tâches associées au projet
        return project.getTasks();
    }
}