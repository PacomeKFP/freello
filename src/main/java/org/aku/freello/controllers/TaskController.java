package org.aku.freello.controllers;

import org.aku.freello.dto.CreateTaskDto;
import org.aku.freello.models.Project;
import org.aku.freello.models.Task;
import org.aku.freello.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("{id}")
    public void update(@PathVariable UUID id, @RequestBody Task task) {

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        taskService.delete(id);
    }
}
