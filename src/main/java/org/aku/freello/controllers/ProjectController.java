package org.aku.freello.controllers;

import org.aku.freello.dto.CreateProjectDto;
import org.aku.freello.models.Project;
import org.aku.freello.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody CreateProjectDto project) {
        return projectService.create(project);
    }

    @GetMapping
    public Iterable<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Project> findOne(@PathVariable UUID id) {
        return projectService.findOne(id);
    }

    @PatchMapping("{id}")
    public void update(@PathVariable UUID id, @RequestBody Project project) {

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        projectService.delete(id);
    }
}
