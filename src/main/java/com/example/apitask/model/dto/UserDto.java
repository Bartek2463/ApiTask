package com.example.apitask.model.dto;

import com.example.apitask.model.User;
import lombok.*;
import lombok.experimental.Accessors;

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
                .setEmail(userDto.getEmail());
    }

}
