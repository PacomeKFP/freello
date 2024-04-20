package org.enspy.freello.controllers;

import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.Project;
import org.enspy.freello.models.User;
import org.enspy.freello.models.dto.CreateProjectDto;
import org.enspy.freello.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public Iterable<Project> findAll(){
        return projectService.findAll();
    }

    @GetMapping("/projects/{id}")
    public Optional<Project> findOne(@RequestParam UUID id){
        return projectService.findOne(id);
    }

    @PostMapping("/projects")
    public Iterable<Project> createProject(@RequestBody CreateProjectDto createProjectDto, @RequestParam UUID id){
        return projectService.add(createProjectDto, new User(id));
    }

    @PatchMapping("/projects/{id}")
    public Optional<Project> updateProject(@RequestParam UUID id, @RequestBody CreateProjectDto createProjectDto){
        return projectService.update(id, createProjectDto);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@RequestParam UUID id){
        projectService.delete(id);
    }

    @PostMapping("/projects/{projectId}/members/{memberId}")
    public void addMember(@RequestParam UUID projectId, @RequestParam UUID memberId){
        projectService.addMemberToProject(projectId, memberId);
    }
}
