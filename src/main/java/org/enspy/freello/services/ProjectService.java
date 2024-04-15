package org.enspy.freello.services;


import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.enspy.freello.exception.ResourceNotFoundException;
import org.enspy.freello.models.Project;
import org.enspy.freello.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    // Créer un nouveau projet
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Récupérer tous les projets
    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    // Récupérer un projet par son ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé pour cet id :: " + id));
    }

    // Mettre à jour un projet
    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé pour cet id :: " + id));
        project.setName(projectDetails.getName());
        project.setAdmin(projectDetails.getAdmin());
        project.setMembers(projectDetails.getMembers());
        return projectRepository.save(project);
    }

    // Supprimer un projet
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projet non trouvé pour cet id :: " + id));
        projectRepository.delete(project);
    }


}
