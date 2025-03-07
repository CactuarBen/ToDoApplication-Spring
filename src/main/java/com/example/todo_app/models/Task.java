package com.example.todo_app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "task") // Ensures table creation
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // primary key for the database

    @NotBlank(message = "Task name cannot be empty")
    @Size(min = 3, max = 50, message = "Task name must be between 3 and 50 characters")
    private String taskName;

    @NotBlank(message = "Task description cannot be empty")
    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String taskDescription;

    @NotBlank(message = "Task status cannot be empty")
    private String taskStatus;

    @Min(value = 1, message = "Priority must be at least 1")
    @Max(value = 5, message = "Priority cannot be more than 5")
    private int taskPriority;
    private String taskDate;

    public Task(String taskName, String taskDescription, String taskStatus, int taskPriority) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.taskDate = LocalDate.now().toString();
    }

    public Task() {
        this.taskDate = LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public void updateDate() {
        this.taskDate = LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return "Task [taskName=" + taskName + ", taskDescription=" + taskDescription + ", taskStatus=" + taskStatus + ", taskPriority=" + taskPriority + ", taskDate=" + taskDate + "]";
    }
}

