package com.poo.projet.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.projet.models.Project;
import com.poo.projet.repository.ProjectRepository;

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

    public void deleteProject(UUID id){
        projectRepository.deleteById(id);
    }
}
