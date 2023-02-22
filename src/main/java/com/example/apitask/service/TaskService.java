package com.example.apitask.service;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.task.dto.TaskDto;
import com.example.apitask.model.user.dto.UserDto;

import java.util.Optional;

public interface TaskService {

    TaskDto save(Task task);
    void delete(Long id);
    TaskDto update(Long id,TaskDto dto);
    Optional<Task> findByUsername(String username);
}
