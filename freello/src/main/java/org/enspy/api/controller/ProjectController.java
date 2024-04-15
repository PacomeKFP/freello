package org.enspy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.enspy.api.service.*;
import org.enspy.api.model.*;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Projects> getProject(@PathVariable int id) {
        return projectService.getProject(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public Iterable<Projects> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }

    @PostMapping("/")
    public Projects saveProject(@RequestBody Projects project) {
        return projectService.saveProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projects> updateProject(@PathVariable int id, @RequestBody Projects project) {
        Projects updatedProject = projectService.updateProject(project);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}