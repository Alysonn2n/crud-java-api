package com.alysonn.crudapi.dao;

import java.util.List;
import java.util.UUID;

import com.alysonn.crudapi.model.Task;

public interface TaskDao {
    UUID insertTask(UUID taskId, Task task);

    default UUID addTask(Task task) {
        UUID id = UUID.randomUUID();
        return insertTask(id, task);
    }

    List<Task> getTasks();
}
