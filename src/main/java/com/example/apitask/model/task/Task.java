package com.example.apitask.model.task;

import com.example.apitask.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true, fluent = false)
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NonNull
    private String title;

    @Column(name = "description", nullable = false)
    @NonNull
    private String description;

    @Column(name = "status", nullable = false)
    @NonNull
    private Boolean status;


    @Column(name = "dedline", nullable = false)
    private LocalDate dedline;

    @ManyToMany(cascade = CascadeType.REMOVE,mappedBy = "tasks")
    private LinkedList<User> users;



}
