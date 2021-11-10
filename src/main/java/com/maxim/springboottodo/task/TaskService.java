package com.maxim.springboottodo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
