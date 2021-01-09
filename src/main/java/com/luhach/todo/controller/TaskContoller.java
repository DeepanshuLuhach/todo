package com.luhach.todo.controller;

import java.util.List;
import java.util.UUID;

import com.luhach.todo.model.Task;
import com.luhach.todo.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskContoller {

    @Autowired
    TaskService taskService;
    
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task putTask){
        Task task = taskService.addTask(putTask.getDescription());
        return task;
    }
    @DeleteMapping("/tasks/{id}")
    public List<Task> deleteTask(@PathVariable("id") UUID id){
        taskService.deleteTask(id);
        List<Task> allTasks = taskService.getAllTask();
        return allTasks;
    }
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable("id") UUID id){
        Task tasks = taskService.getTask(id);
        return tasks;
    }
    @PutMapping("/tasks/{id}/status")
    public Task changeTaskStatus(@PathVariable("id") UUID id){
        Task task = taskService.changeTaskStatus(id);
        return task;
    }
    @PutMapping("/tasks/{id}/description")
    public Task changeDescription(@PathVariable("id") UUID id, @RequestBody String description){
        Task task = taskService.changeDescription(id, description);
        return task;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(Model model){
        List<Task> allTasks= taskService.getAllTask();
        return allTasks;
    }
}
