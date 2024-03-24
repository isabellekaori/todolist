package com.estudodejava.todolist.service;

import com.estudodejava.todolist.exception.TaskNotFoundException;
import com.estudodejava.todolist.exception.taskAlreadyExistsException;
import com.estudodejava.todolist.model.Task;
import com.estudodejava.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task addTask(Task task) {
        if(taskAlreadyExists(task.getName())){
            throw new taskAlreadyExistsException(task.getName() + "already exists!");
        }

        return taskRepository.save(task);
    }

    @Override
    public Task uptadeTask(Task task, Long id) {
        return taskRepository.findById(id).map(tsk -> {
            tsk.setName(task.getName());
            tsk.setStatus(task.getStatus());
            tsk.setDescription(task.getDescription());
            return taskRepository.save(tsk);
        }).orElseThrow(()-> new TaskNotFoundException("Sorry, this task could not be found"));
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException("Sorry, task not found"));
    }

    @Override
    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException("Sorry task not found");
        }
        taskRepository.deleteById(id);
    }
    private boolean taskAlreadyExists(String name) {
        return taskRepository.findByEmail(name).isPresent();
    }
}
