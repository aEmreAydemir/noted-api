package com.aydemir.notedapi.service;

import com.aydemir.notedapi.dto.Task;
import com.aydemir.notedapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getList(String userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public boolean delete(String userId, String taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.get().getUserId().equals(userId)) {
           taskRepository.deleteById(taskId);
           return true;
        }
        return false;
    }
}
