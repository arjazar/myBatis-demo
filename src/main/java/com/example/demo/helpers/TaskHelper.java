package com.example.demo.helpers;

import com.example.demo.models.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TaskHelper {
    static public String listToJson(List<Task> taskList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(taskList);
    }
}
