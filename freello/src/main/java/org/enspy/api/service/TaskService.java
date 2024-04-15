package org.enspy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import org.enspy.api.model.*;
import org.enspy.api.repository.*;

import lombok.Data;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Optional<Tasks> getTask(final int id) {
        return taskRepository.findById(id);
    }

    public Iterable<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(final int id) {
        taskRepository.deleteById(id);
    }

    public Tasks saveTask(Tasks task) {
        return taskRepository.save(task);
    }

    public Tasks updateTask(Tasks task) {
        if (task.getId() != null && taskRepository.existsById(task.getId())) {
            return taskRepository.save(task);
        }
        throw new EntityNotFoundException("Task with id " + task.getId() + " not found.");
    }
}