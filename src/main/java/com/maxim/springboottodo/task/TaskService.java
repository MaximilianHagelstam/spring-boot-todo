package com.maxim.springboottodo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Task> getTaskById(Integer taskId) {
        return taskRepository.findById(taskId);
    }

    @Transactional
    public Task updateTask(Integer taskId, Task task) {
        Task updatedTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "task with id " + taskId + " does not exist"
                ));

        updatedTask.setDescription(task.getDescription());
        updatedTask.setTitle(task.getTitle());
        
        return updatedTask;
    }
}
