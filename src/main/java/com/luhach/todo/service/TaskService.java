package com.luhach.todo.service;

import java.util.List;
import java.util.UUID;

import com.luhach.todo.aop.TrackTime;
import com.luhach.todo.model.Task;
import com.luhach.todo.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //Custom Annotation defined to track the time taken by the method using AOP and around advice
    @TrackTime
    public Task addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        System.out.println("Created :: " + task.toString());
        taskRepository.save(task);
        return task;
    }

    @TrackTime
    public List<Task> getAllTask() {
        List<Task> allTasks = taskRepository.findAll();
        System.out.println("All tasks :: " + allTasks.toString());
        return allTasks;
    }

    @TrackTime
    public void deleteTask(UUID id) {
        System.out.println("Deleted :: " + taskRepository.findById(id).orElse(null).toString());
        taskRepository.deleteById(id);
        return;
    }

    @TrackTime
    public Task getTask(UUID id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null)
            return null;
        System.out.println("Fetched Task :: " + task.toString());
        return task;
    }

    @TrackTime
    public Task changeTaskStatus(UUID id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null)
            return null;
        Integer status = task.getStatus();
        task.setStatus((status+1)%2);
        taskRepository.save(task);
        System.out.println("Updated Task :: " + task.toString());
        return task;
    }

    @TrackTime
    public Task changeDescription(UUID id, String description){
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null)
            return null;
        task.setDescription(description);
        taskRepository.save(task);
        System.out.println("Updated Task :: " + task.toString());
        return task;
    }

}
