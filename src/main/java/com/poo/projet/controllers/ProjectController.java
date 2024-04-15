package com.poo.projet.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poo.projet.models.Project;
import com.poo.projet.models.require.ProjectRequire;
import com.poo.projet.services.ProjectService;
/**
 * ProjectController
 */

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public Iterable<Project> showProject(){
        return projectService.getProject();
    }

    @GetMapping("/projects/{id}")
    public Optional<Project> searchproject(@RequestParam UUID id){
        return projectService.findOne(id);
    }

    @PostMapping("/projects")
    public Iterable<Project> addProject(@RequestBody ProjectRequire projectRequire){
        projectService.createProject(projectRequire);
        return projectService.getProject();
    }

    @PatchMapping("/projects/{id}")
    public Optional<Project> updateProject(@RequestParam UUID id, @RequestBody ProjectRequire projectRequire){
        projectService.updateProject(id, projectRequire);
        return projectService.findOne(id);
    }
    
    @DeleteMapping("/projects/{id}")
    public void deleteProject(@RequestParam UUID id){
        projectService.deleteProject(id);
    }
}
