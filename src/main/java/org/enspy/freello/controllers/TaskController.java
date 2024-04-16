package org.enspy.freello.controllers;

import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.Task;
import org.enspy.freello.models.dto.CreateTaskDto;
import org.enspy.freello.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> showTask(){
        return taskService.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> findOne(@RequestParam UUID id){
        return taskService.findOne(id);
    }

    @PostMapping("/tasks")
    public Optional<Task> create(@RequestBody CreateTaskDto createTaskDto){
        return taskService.add(createTaskDto);
    }

    @PatchMapping("/tasks/{id}")
    public Optional<Task> updateTask(@RequestParam UUID id, @RequestBody CreateTaskDto createTaskDto){
        return taskService.update(id, createTaskDto);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@RequestParam UUID id){
        taskService.delete(id);
    }
}
