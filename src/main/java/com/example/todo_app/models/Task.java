package com.example.todo_app.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private String taskDate;
    private int taskPriority;

    public Task(String taskName, String taskDescription, String taskStatus, int taskPriority) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.taskDate = LocalDate.now().toString();
    }

    public Task() {
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

