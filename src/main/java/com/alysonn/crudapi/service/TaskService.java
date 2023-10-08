package com.alysonn.crudapi.service;

import java.util.List;
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
    public TaskService(@Qualifier("DAO") TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public UUID addTask(Task task) {
        return taskDao.addTask(task);
    }

    public List<Task> getTasks() {
        return taskDao.getTasks();
    }
}
