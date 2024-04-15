package com.poo.projet.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.Tasks;
import com.poo.projet.models.require.TaskRequire;
import com.poo.projet.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Tasks> getTask(){
        return taskRepository.findAll();
    }

    public Optional<Tasks> findOne(UUID id){
        return taskRepository.findById(id);
    }

    public Tasks savTask(Tasks task){
        return taskRepository.save(task);
    }

    public void createTask(@Valid @ModelAttribute TaskRequire taskRequire){
        Tasks tasks = new Tasks();
        tasks.setTitle(taskRequire.getTitle());
        tasks.setDescription(taskRequire.getDescription());
        tasks.setStatus(tasks.getStatus());

        taskRepository.save(tasks);
    }

    public void updateTask(@RequestParam UUID id, @Valid @ModelAttribute TaskRequire taskRequire){
        Optional<Tasks> tasks = taskRepository.findById(id);
        tasks.get().setTitle(taskRequire.getTitle());
        tasks.get().setDescription(taskRequire.getDescription());
        tasks.get().setStatus(tasks.get().getStatus());
        
        taskRepository.save(tasks.get());
    }

    public void deleteTask(UUID id){
        taskRepository.deleteById(id);
    }
}
