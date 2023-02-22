package com.example.apitask.service;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.task.dto.TaskDto;

import java.util.Optional;

public interface TaskService {

    TaskDto save(Task task);
    void delete(Long id);
    TaskDto update(Long id,TaskDto dto);
    Optional<Task> findByTaskName(String username);
    Optional<Task> findById(Long taskId);


}
