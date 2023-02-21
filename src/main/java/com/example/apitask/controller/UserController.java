package com.example.apitask.controller;

import com.example.apitask.exception.ElementAlredyExistsException;
import com.example.apitask.model.User;
import com.example.apitask.model.dto.UserDto;
import com.example.apitask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/addUser") // add new user and validation
    public ResponseEntity<?> addUser(@RequestBody User user) {

        if (userService.findByEmail(user.getEmail()).isPresent() || userService.findByLastname(user.getLastname()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (user.getEmail() == null || user.getFirstname() == null || user.getLastname() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/findUser/{userName}")
    public ResponseEntity<?> getUserByName(@PathVariable("userName")String userName){

        Optional<User> byLastname = userService.findByLastname(userName);
        if(byLastname.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        User user = byLastname.get();
        UserDto userDto = UserDto.mapToDto(user);
        return new ResponseEntity<>(userDto,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")



}
