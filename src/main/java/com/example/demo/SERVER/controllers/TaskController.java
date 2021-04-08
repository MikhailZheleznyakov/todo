package com.example.demo.SERVER.controllers;

import com.example.demo.SERVER.repository.TaskRepository;
import com.example.demo.SERVER.tables.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @PostMapping("/addTask")
    Task createTask(@RequestBody Task task){
        return this.taskRepository.save(task);
    }

    @GetMapping("/getTask={id}")
    Task getTask(@PathVariable Long id){
        return this.taskRepository.findTaskById(id);
    }

    @GetMapping("/getTaskAll")
    List<Task> getTaskAll(){
        return this.taskRepository.findAll();
    }
}
