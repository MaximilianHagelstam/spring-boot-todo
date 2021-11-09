package com.maxim.springboottodo.task;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {
    public List<Task> getTasks() {
        return List.of(new Task(1L, "james", "jugu"));
    }
}
