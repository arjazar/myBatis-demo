package com.example.demo.services;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskMapper taskMapper;
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public Task findTaskById(long taskId) {
        Task task = taskMapper.getTaskById(taskId);
        return task;
    }

    public Task insertTask(String taskTitle, String taskDescription, Integer taskStatus, Date taskDueDate) {
        Timestamp taskTimestamp = taskDueDate != null ? new Timestamp(taskDueDate.getTime()): null;
        Task task = new Task(taskTitle, taskDescription, taskTimestamp, taskStatus);
        taskMapper.insertTask(task);
        // The ID of the inserted task is now available in the 'id' field of the Task object.
        return task;
    }

    public void deleteTask(long taskId) {
        taskMapper.deleteTask(taskId);
        // The ID of the inserted task is now available in the 'id' field of the Task object.
    }

    public Task updateTask(long taskId, String taskTitle, String taskDescription, Integer taskStatus, Date taskDueDate) {
        Timestamp taskTimestamp = new Timestamp(taskDueDate.getTime());
        Task taskTobeUpdated = taskMapper.getTaskById(taskId);
        taskTobeUpdated.setTaskTitle(taskTitle);
        taskTobeUpdated.setTaskStatus(taskStatus);
        taskTobeUpdated.setTaskDueDate(taskTimestamp);
        taskTobeUpdated.setTaskDescription(taskDescription);
        taskMapper.updateTask(taskTobeUpdated);
        return findTaskById(taskId);
    }

    public List<Task> selectAllTasks() {
        return taskMapper.getAllTasks();
    }
}
