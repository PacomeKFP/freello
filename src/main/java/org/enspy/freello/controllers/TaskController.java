package org.enspy.freello.controllers;

import org.enspy.freello.models.Tasks;
import org.enspy.freello.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    // Créer une nouvelle tâche
    @PostMapping("/")
    public Tasks createTask(@RequestBody Tasks task) {
        return taskService.createTask(task);
    }

    // Récupérer toutes les tâches
    @GetMapping("/")
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Récupérer une tâche par son ID
    @GetMapping("/{id}")
    public Tasks getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    // Mettre à jour une tâche
    @PutMapping("/{id}")
    public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks task) {
        return taskService.updateTask(id, task);
    }

    // Supprimer une tâche
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();}

    @PostMapping("/{taskId}/collaborators/{userId}")
    public Tasks addCollaborator(@PathVariable Long taskId, @PathVariable Long userId) {
        return taskService.addCollaboratorToTask(taskId, userId);
}



}
