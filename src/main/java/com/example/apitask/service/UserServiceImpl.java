package com.example.apitask.service;

import com.example.apitask.model.user.User;
import com.example.apitask.model.user.dto.UserDto;
import com.example.apitask.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(User user) {
        User saveUser = userRepository.save(user);
        return UserDto.mapToDto(saveUser);
    }

    @Override
    public UserDto updateById(UserDto userDto, Long id) {
        Optional<User> userOptional = findUserById(id);
        if (userOptional.isEmpty()) {
            return null;
        }
        User userEnt = userOptional.get();
        if (userDto.getFirstName() != null)
            userEnt.setFirstname(userDto.getFirstName());

        if (userDto.getLastName() != null)
            userEnt.setLastname(userDto.getLastName());
        if (userDto.getEmail() != null) {
            userEnt.setEmail(userDto.getEmail());
        }
        User update = userRepository.save(userEnt);
        return UserDto.mapToDto(update);
    }

    @Override
    public void delete(Long appId) {
        userRepository.deleteById(appId);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findByLastname(String lastName) {
        return userRepository.findUserByLastname(lastName);
    }
}
