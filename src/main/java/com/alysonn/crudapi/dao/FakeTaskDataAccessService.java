package com.alysonn.crudapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.alysonn.crudapi.model.Task;

@Repository("DAO")
public class FakeTaskDataAccessService implements TaskDao {
    private static List<Task> db = new ArrayList<>();

    @Override
    public UUID insertTask(UUID taskId, Task task) {
        db.add(new Task(taskId, task.getName(), task.getDescription(),
                // task.getStatus(),
                task.getFinishDate(), task.getCreationDate()));
        return UUID.randomUUID();
    }

    @Override
    public List<Task> getTasks() {
        return db;
    }

    @Override
    public String deleteTaskById(UUID taskId) {
        Optional<Task> task = getTaskById(taskId);
        if (task.isEmpty()) {
            return "Task does not exist";
        }

        db.remove(task.get());
        return "Success";
    }

    @Override
    public Optional<Task> getTaskById(UUID taskId) {
        return db.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .findFirst();
    }

    @Override
    public String updateTaskById(UUID taskId, Task newTask) {
        return getTaskById(taskId)
                .map(actualTask -> {
                    int actualTaskIndex = db.indexOf(actualTask);
                    if (actualTaskIndex >= 0) {
                        db.set(actualTaskIndex, new Task(taskId, newTask.getName(), newTask.getDescription(),
                                newTask.getFinishDate(), newTask.getCreationDate()));
                        return "Success";
                    }

                    return "Could not update task";
                })
                .orElse("Task does not exist");
    }
}
