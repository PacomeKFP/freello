package com.poo.projet.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.Project;
import com.poo.projet.models.require.ProjectRequire;
import com.poo.projet.services.ProjectService;

import jakarta.validation.Valid;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public void showProject(Model model){
        Iterable<Project> projects = projectService.getProject();
        model.addAttribute("projects", projects);
    }
    @PostMapping("/create")
    public void addProject(@Valid @ModelAttribute ProjectRequire projectRequire){
        projectService.createProject(projectRequire);
    }

    @PostMapping("/edit")
    public void updateProject(@RequestParam UUID id, @Valid @ModelAttribute ProjectRequire projectRequire){
        projectService.updateProject(id, projectRequire);
    }
    
    @GetMapping("/delete")
    public void deleteProject(@RequestParam UUID id){
        projectService.deleteProject(id);
    }
}
