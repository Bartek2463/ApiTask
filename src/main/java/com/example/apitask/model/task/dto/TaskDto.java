package com.example.apitask.model.task.dto;

import com.example.apitask.model.task.Task;
import com.example.apitask.model.user.User;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.LinkedList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private Boolean status;
    private LocalDate dedline;

    public static Task mapToModel(TaskDto dto){
        return new Task()
                .setId(dto.getId())
                .setTitle(dto.getTitle())
                .setDescription(dto.getDescription())
                .setStatus(dto.getStatus())
                .setDedline(dto.getDedline())
                .setUsers(new LinkedList<>());
    }

    public static TaskDto mapToDto(Task task){

        return new TaskDto()
                .setId(task.getId())
                .setTitle(task.getTitle())
                .setDescription(task.getDescription())
                .setStatus(task.getStatus())
                .setDedline(task.getDedline());

    }


}
