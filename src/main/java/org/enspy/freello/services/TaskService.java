package org.enspy.freello.services;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.enspy.freello.models.Task;
import org.enspy.freello.models.dto.CreateTaskDto;
import org.enspy.freello.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findOne(UUID id){
        return taskRepository.findById(id);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> add(CreateTaskDto createTaskDto){
        Task task = new Task(createTaskDto.getTitle(), createTaskDto.getDescription(), "Pending", new Date(System.currentTimeMillis()), createTaskDto.getProjectAsProject());

        taskRepository.save(task);

        return taskRepository.findById(task.getId());
    }

    public Optional<Task> update(UUID id, CreateTaskDto createTaskDto){
        Optional<Task> taskOpt = taskRepository.findById(id);
        if(taskOpt.isPresent()){
            Task task = taskOpt.get();
            task.setTitle(createTaskDto.getTitle());
            task.setDescription(createTaskDto.getDescription());
            taskRepository.save(task);
        }
        return taskOpt;
    }

    public void delete(UUID id){
        taskRepository.deleteById(id);
    }
}
