package com.alysonn.crudapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alysonn.crudapi.dao.TaskDao;
import com.alysonn.crudapi.model.Task;

@Service
public class TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskService(@Qualifier("postgres") TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public UUID addTask(Task task) {
        return taskDao.addTask(task);
    }

    public List<Task> getTasks() {
        return taskDao.getTasks();
    }

    public String deleteTaskById(UUID taskId) {
        return taskDao.deleteTaskById(taskId);
    }

    public Optional<Task> getTaskById(UUID taskId) {
        return taskDao.getTaskById(taskId);
    }

    public String updateTaskById(UUID taskId, Task newTask) {
        return taskDao.updateTaskById(taskId, newTask);
    }
}
