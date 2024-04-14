package com.poo.projet.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.projet.models.Tasks;
import com.poo.projet.repository.TaskRepository;

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

    public void deleteTask(UUID id){
        taskRepository.deleteById(id);
    }
}
