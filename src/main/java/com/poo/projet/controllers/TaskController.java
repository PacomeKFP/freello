package com.poo.projet.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poo.projet.models.Tasks;
import com.poo.projet.models.require.TaskRequire;
import com.poo.projet.services.TaskService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Tasks> showTask(Model model){
        return taskService.getTask();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Tasks> searchtask(@RequestParam UUID id){
        return taskService.findOne(id);
    }

    @PostMapping("/tasks")
    public Iterable<Tasks> addTask(@RequestBody TaskRequire taskRequire){
        taskService.createTask(taskRequire);
        return taskService.getTask();
    }

    @PatchMapping("/tasks/{id}")
    public Optional<Tasks> updateTask(@RequestParam UUID id, @RequestBody TaskRequire taskRequire){
        taskService.updateTask(id, taskRequire);
        return taskService.findOne(id);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@RequestParam UUID id){
        taskService.deleteTask(id);
    }
}
