package com.alysonn.crudapi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.alysonn.crudapi.model.Task;

@Repository("postgres")
public class TaskDataAcessService implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDataAcessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID insertTask(UUID taskId, Task task) {
        final String query = "insert into task (task_id, name, description, finish_date, creation_date) values (?, ?, ?, ?, ?)";
        UUID taskUUID = UUID.randomUUID();
        jdbcTemplate.update(query, taskUUID, task.getName(), task.getDescription(), task.getFinishDate(),
                task.getCreationDate());
        return taskUUID;
    }

    @Override
    public List<Task> getTasks() {
        final String query = "SELECT * FROM task";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            return new Task(
                    UUID.fromString(resultSet.getString("task_id")),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDate("finish_date"),
                    resultSet.getDate("creation_date"));
        });
    }

    @Override
    public String deleteTaskById(UUID taskId) {
        final String query = "delete from task where task_id = ?";
        Optional<Task> task = getTaskById(taskId);
        if (task.isEmpty()) {
            return "Task does not exist";
        }
        jdbcTemplate.update(query, taskId);
        return "Success";
    }

    @Override
    public Optional<Task> getTaskById(UUID taskId) {
        final String query = "SELECT * FROM task where task_id = ?";
        List<Task> task = jdbcTemplate.queryForList(query,
                new Object[] {
                        taskId,
                },
                Task.class);
        return task.stream().findFirst();
    }

    /* TO DO: find a better way to update only columns user have sent */
    @Override
    public String updateTaskById(UUID taskId, Task newTask) {
        String query = "update task set name = ?, description = ?, finish_date = ? where task_id = ? ";
        Optional<Task> task = getTaskById(taskId);
        if (task.isEmpty()) {
            return "Task does not exist";
        }
        jdbcTemplate.update(query, newTask.getName(), newTask.getDescription(), newTask.getFinishDate(), taskId);
        return "Success";
    }

}
