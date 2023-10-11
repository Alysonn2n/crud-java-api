package com.alysonn.crudapi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.alysonn.crudapi.model.Task;

public interface TaskDao {
    UUID insertTask(UUID taskId, Task task);

    default UUID addTask(Task task) {
        UUID id = UUID.randomUUID();
        return insertTask(id, task);
    }

    List<Task> getTasks();

    String deleteTaskById(UUID taskId);

    Optional<Task> getTaskById(UUID taskId);

    String updateTaskById(UUID taskId, Task newTask);
}
