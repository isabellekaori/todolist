package com.estudodejava.todolist.service;

import com.estudodejava.todolist.model.Task;

import java.util.List;

public interface ITaskService {

    Task addTask (Task task);
    List<Task> getTasks();
    Task uptadeTask(Task task, Long id);
    Task getTaskById(Long id);
    void deleteTask(Long id);
}
