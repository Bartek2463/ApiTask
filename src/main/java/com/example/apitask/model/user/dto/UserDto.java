package com.example.apitask.model.user.dto;

import com.example.apitask.model.user.User;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.LinkedList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
public class UserDto {


    private String firstName;
    private String lastName;
    private String email;


    public static UserDto mapToDto(User user){
        return  new UserDto()
                .setFirstName(user.getFirstname())
                .setLastName(user.getLastname())
                .setEmail(user.getEmail());
    }
    public static User mapToModel(UserDto userDto){
        return  new User()
                .setFirstname(userDto.getFirstName())
                .setLastname(userDto.getLastName())
                .setEmail(userDto.getEmail())
                .setTasks(new LinkedList<>());
    }

}
