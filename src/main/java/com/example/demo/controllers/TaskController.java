package com.example.demo.controllers;

import com.example.demo.helpers.TaskHelper;
import com.example.demo.models.Task;
import com.example.demo.models.api.ApiResponse;
import com.example.demo.models.request.CreateTaskModel;
import com.example.demo.services.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

//    @GetMapping
//    public ResponseEntity<ApiResponse> getAllTasks() {
//        try {
//            return ResponseEntity.ok(TaskHelper.listToJson(taskService.selectAllTasks()));
//        } catch (JsonProcessingException e) {
//            return ResponseEntity.badRequest().body("Unknown error");
//        }
//    }


    @GetMapping("/{taskId}")
    public ResponseEntity<String> getTaskById(@PathVariable long taskId) {
        try {
            return ResponseEntity.ok(taskService.findTaskById(taskId).toJson());
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Unknown error");
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable long taskId) {
            taskService.deleteTask(taskId);
            return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable long taskId,
                                             @RequestBody CreateTaskModel createTaskModel) {
        try {
            return ResponseEntity.ok(taskService.updateTask(taskId, createTaskModel.getTaskTitle(), createTaskModel.getTaskDescription(), createTaskModel.getTaskStatus(), createTaskModel.getTaskDueDate()).toJson());
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Unknown error");
        }

    }
    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody CreateTaskModel createTaskModel) {
        try {
            return ResponseEntity.ok(taskService.insertTask(createTaskModel.getTaskTitle(), createTaskModel.getTaskDescription(), createTaskModel.getTaskStatus(), createTaskModel.getTaskDueDate()).toJson());
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Unknown error");
        }
    }

}