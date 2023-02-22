package com.example.apitask.service;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.task.dto.TaskDto;
import com.example.apitask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

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
        Task task = null;
        Optional<Task> tasksById = taskRepository.findTasksById(id);
        if (tasksById.isPresent()) {
            task = tasksById.get();
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setStatus(dto.getStatus());
            task.setDedline(dto.getDedline());
            task.setUsers(dto.getUsers());
        }
        Task save = taskRepository.save(task);
        return TaskDto.mapToDto(save);
    }

    @Override
    public Optional<Task> findByUsername(String username) {
        return taskRepository.findTaskByName(username);
    }
}
