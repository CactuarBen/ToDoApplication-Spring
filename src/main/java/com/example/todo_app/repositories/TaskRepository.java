package com.example.todo_app.repositories;

import com.example.todo_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
