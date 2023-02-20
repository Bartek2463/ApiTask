package com.example.apitask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

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
