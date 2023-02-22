package com.example.apitask.controller;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.task.dto.TaskDto;
import com.example.apitask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<?> saveTask(@RequestParam Task task) {

        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable("taskId") Long taskId, @RequestBody TaskDto taskDto) {

        TaskDto update = taskService.update(taskId, taskDto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTask(@PathVariable("taskId") Long taskId) {
        taskService.findById(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<?> deleteTask(@PathVariable("taskId") Long taskId) {

        taskService.delete(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
