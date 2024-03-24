package com.estudodejava.todolist.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
