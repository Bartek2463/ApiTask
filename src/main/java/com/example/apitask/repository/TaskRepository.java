package com.example.apitask.repository;

import com.example.apitask.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Optional<Task> findTasksById(Long id);
    Optional<Task> findTaskByName(String name);

}
