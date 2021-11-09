package com.maxim.springboottodo.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    @GetMapping
    public List<Task> getTasks() {
        return List.of(new Task(1L, "james", "jugu"));
    }
}
