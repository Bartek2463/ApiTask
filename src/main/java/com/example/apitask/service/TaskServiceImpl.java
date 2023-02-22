package com.example.apitask.service;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.task.dto.TaskDto;
import com.example.apitask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;


    @Override
    public TaskDto save(Task task) {
        Task taskSave = taskRepository.save(task);
        return TaskDto.mapToDto(taskSave);
    }


    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto update(Long id, TaskDto dto) {
        Optional<Task> tasksById = taskRepository.findTasksById(id);
        if(tasksById.isPresent()){

        }
    }

    @Override
    public Optional<Task> findByUsername(String username) {
        return taskRepository.findTaskByName(username);
    }
}
