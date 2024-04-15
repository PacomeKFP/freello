package org.enspy.freelo.controllers;

import org.enspy.freelo.models.Project;
import org.enspy.freelo.models.dto.CreateProjectDto;
import org.enspy.freelo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    // create a new Project
    @PostMapping("/projects")
    public Iterable<Project> createProject(@RequestBody CreateProjectDto projectDto){
        return (Iterable<Project>) projectService.add(projectDto);
    }
    // get all project
    @GetMapping("/projects")
    public Iterable<Project> findAll(){
        return projectService.findAll();

    }
    @PostMapping ("/projects/{id}")
    public Optional<Project> findOne(@RequestParam UUID id){
        return projectService.findOne(id);

    }
    @PutMapping("projects/{id}")
    public Project updateProject(@PathVariable UUID id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }
}
