package com.estudodejava.todolist.exception;

public class taskAlreadyExistsException extends RuntimeException {
    public taskAlreadyExistsException(String message) {
        super(message);
    }
}
