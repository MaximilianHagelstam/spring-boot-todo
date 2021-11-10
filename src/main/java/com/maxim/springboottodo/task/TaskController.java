package com.maxim.springboottodo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("{taskId}")
    public void deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping("{taskId}")
    public Optional<Task> getTaskById(@PathVariable("taskId") Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("{taskId}")
    public Task updateTask(@PathVariable("taskId") Integer taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }
}
