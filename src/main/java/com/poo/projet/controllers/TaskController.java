package com.poo.projet.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.Tasks;
import com.poo.projet.models.require.TaskRequire;
import com.poo.projet.services.TaskService;

import jakarta.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    public void showTask(Model model){
        Iterable<Tasks> tasks = taskService.getTask();
        model.addAttribute("tasks", tasks);
    }

    @PostMapping("/createtask")
    public void addTask(@Valid @ModelAttribute TaskRequire taskRequire){
        taskService.createTask(taskRequire);
    }

    @PostMapping("/edittask")
    public void updateTask(@RequestParam UUID id, @Valid @ModelAttribute TaskRequire taskRequire){
        taskService.updateTask(id, taskRequire);
    }

    @GetMapping("/deletetask")
    public void deleteTask(@RequestParam UUID id){
        taskService.deleteTask(id);
    }
}
