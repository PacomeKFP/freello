package org.enspy.freelo.controllers;

import org.enspy.freelo.models.Task;
import org.enspy.freelo.models.dto.CreateTaskDto;
import org.enspy.freelo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody CreateTaskDto task) {
        return taskService.create(task);
    }

    @GetMapping
    public Iterable<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Task> findOne(@PathVariable UUID id) {
        return taskService.findOne(id);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
    @PostMapping("/{taskId}/collaborators/{userId}")
    public Task addCollaborator(@PathVariable UUID taskId, @PathVariable UUID userId) {
        return taskService.addCollaboratorToTask(taskId, userId);
    }
}
