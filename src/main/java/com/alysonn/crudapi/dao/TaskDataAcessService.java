package com.alysonn.crudapi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.alysonn.crudapi.model.Task;

@Repository("postgres")
public class TaskDataAcessService implements TaskDao {

    @Override
    public UUID insertTask(UUID taskId, Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertTask'");
    }

    @Override
    public List<Task> getTasks() {
        return List.of(new Task(UUID.randomUUID(), "Test", null, null, null ));
    }

    @Override
    public String deleteTaskById(UUID taskId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTaskById'");
    }

    @Override
    public Optional<Task> getTaskById(UUID taskId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTaskById'");
    }

    @Override
    public String updateTaskById(UUID taskId, Task newTask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTaskById'");
    }
    
}
