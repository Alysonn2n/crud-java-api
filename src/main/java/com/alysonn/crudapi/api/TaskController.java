package com.alysonn.crudapi.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alysonn.crudapi.model.Task;
import com.alysonn.crudapi.service.TaskService;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

@RequestMapping("api/v1/task")
@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@Valid @Nonnull @RequestBody Task task) {
        taskService.addTask(task);
    }


    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(path = "{taskId}")
    public Optional<Task> getTaskById(@PathVariable("taskId") UUID taskId) {
        return taskService.getTaskById(taskId);
    }

    @DeleteMapping(path = "{taskId}")
    public String deleteTaskById(@PathVariable("taskId") UUID taskId) {
        return taskService.deleteTaskById(taskId);
    }

    @PutMapping(path = "{taskId}")
    public String updateTaskById(@PathVariable("taskId") UUID taskId, @Valid @Nonnull @RequestBody Task task) {
        return taskService.updateTaskById(taskId, task);
    }
}
