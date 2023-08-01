package com.example.demo.mapper;

import com.example.demo.models.Task;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface TaskMapper {
    Task getTaskById(long id);
    List<Task> getAllTasks();
    void insertTask(Task task);
    void updateTask(Task task);
    void deleteTask(long id);
}
