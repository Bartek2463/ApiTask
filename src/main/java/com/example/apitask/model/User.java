package com.example.apitask.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

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


}
