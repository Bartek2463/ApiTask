package com.example.apitask.controller;

import com.example.apitask.service.TaskService;
import com.example.apitask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

 private  final TaskService taskService;
 private final UserService userService;




}
