package com.example.todo_app.controllers;

import com.example.todo_app.models.Task;
import com.example.todo_app.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks") // Base path for all task-related endpoints
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping // Base get to show all tasks
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}") // Base single-id get to show one task
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = service.getTaskById(id);
        return (task != null) ? new ResponseEntity<>(task, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping // Base post that posts the JSON with information
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Task task = service.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build(); // Return 404 if task doesn't exist
        }

        // Update existing task fields
        task.setTaskName(updatedTask.getTaskName());
        task.setTaskDescription(updatedTask.getTaskDescription());
        task.setTaskStatus(updatedTask.getTaskStatus());
        task.setTaskPriority(updatedTask.getTaskPriority());

        Task savedTask = service.updateTask(task); // Save changes
        return ResponseEntity.ok(savedTask); // Return updated task
    }


    @DeleteMapping("/{id}") // Base delete that removes one entity from the database
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
