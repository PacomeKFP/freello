package com.poo.projet.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.Project;
import com.poo.projet.models.require.ProjectRequire;
import com.poo.projet.repository.ProjectRepository;

import jakarta.validation.Valid;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Iterable<Project> getProject(){
        return projectRepository.findAll();
    }

    public Optional<Project> findOne(UUID id){
        return projectRepository.findById(id);
    }

    public Project savProject(Project project){
        return projectRepository.save(project);
    }

    public void createProject(@Valid @ModelAttribute ProjectRequire projectRequire){
        Project project = new Project();
        project.setName(projectRequire.getName());
        projectRepository.save(project);
    }

    public void updateProject(@RequestParam UUID id, @Valid @ModelAttribute ProjectRequire projectRequire){
        Optional<Project> projects = projectRepository.findById(id);
        
        projects.get().setName(projectRequire.getName());
        projectRepository.save(projects.get());
    }

    public void deleteProject(UUID id){
        projectRepository.deleteById(id);
    }
}
