package org.aku.freello.services;

import lombok.Data;
import org.aku.freello.dto.CreateTaskDto;
import org.aku.freello.models.Task;
import org.aku.freello.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Data
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task create(CreateTaskDto createTaskDto) {
        Task task = new Task(createTaskDto.getName(), createTaskDto.getDescription());
        return taskRepository.save(task);
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findOne(UUID id) {
        return taskRepository.findById(id);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

}
