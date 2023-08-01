package com.example.demo.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

import java.sql.Timestamp;

public class Task {
    private long taskId;
    private String taskTitle;
    private String taskDescription;
    private Timestamp taskDueDate;
    private Integer taskStatus;

    public Task(long taskId, String taskTitle, String taskDescription, Timestamp taskDueDate, Integer taskStatus) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskStatus = taskStatus;
    }

    public Task(String taskTitle, String taskDescription, Timestamp taskDueDate, Integer taskStatus) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskStatus = taskStatus;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Timestamp getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Timestamp taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
            "taskId=" + taskId +
            ", taskTitle='" + taskTitle + '\'' +
            ", taskDescription='" + taskDescription + '\'' +
            ", taskDueDate=" + taskDueDate +
            ", taskStatus=" + taskStatus +
            '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);

    }
}
