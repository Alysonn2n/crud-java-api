package com.alysonn.crudapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.alysonn.crudapi.model.Task;

@Repository("DAO")
public class TaskDataAccessService implements TaskDao {
    private static List<Task> DB = new ArrayList<>();

    @Override
    public UUID insertTask(UUID taskId, Task task) {
        DB.add(new Task(taskId, task.getName(), task.getDescription(),
                // task.getStatus(),
                task.getFinishDate(), task.getCreationDate()));
        return UUID.randomUUID();
    }


    public List<Task> getTasks() {
        return DB;
    }
}
