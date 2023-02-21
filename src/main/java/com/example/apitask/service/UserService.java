package com.example.apitask.service;

import com.example.apitask.model.User;
import com.example.apitask.model.dto.UserDto;

import java.util.Optional;

public interface UserService {

    UserDto saveUser(User user);
    UserDto updateById(UserDto userDto, Long id);
    void delete(Long appId);


    Optional<User> findUserById(Long UserId);
    Optional<User> findByEmail(String email);
    Optional<User> findByLastname(String username);

}
