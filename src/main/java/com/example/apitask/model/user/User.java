package com.example.apitask.model.user;

import com.example.apitask.model.task.Task;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true, fluent = false)
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    @NonNull
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NonNull
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_task",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="task_id")
    )
    private LinkedList<Task> tasks = new LinkedList<>();


}
