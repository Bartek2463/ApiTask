package com.example.apitask.controller;

import com.example.apitask.exception.ElementAlredyExistsException;
import com.example.apitask.model.User;
import com.example.apitask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class UserController {

    private UserService userService;
    private ElementAlredyExistsException exception;

    public UserController(UserService userService, ElementAlredyExistsException exception) {
        this.userService = userService;
        this.exception = exception;
    }

    @PostMapping("/addUser") // add new user and validation
    public ResponseEntity<?> addUser(@RequestBody User user){

        if(userService.findByEmail(user.getEmail()).isPresent() || userService.findByLastname(user.getLastname()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (user.getEmail()==null || user.getFirstname()==null || user.getLastname()==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }



}
