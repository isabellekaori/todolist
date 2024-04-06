package com.estudodejava.todolist.repository;

import com.estudodejava.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByName(String name);
}
