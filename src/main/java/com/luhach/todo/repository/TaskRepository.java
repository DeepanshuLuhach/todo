package com.luhach.todo.repository;

import java.util.UUID;

import com.luhach.todo.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,UUID>{
    
}
