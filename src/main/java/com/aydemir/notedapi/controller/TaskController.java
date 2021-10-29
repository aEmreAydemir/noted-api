package com.aydemir.notedapi.controller;

import com.aydemir.notedapi.dto.Task;
import com.aydemir.notedapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@CrossOrigin(origins = "https://noted-web-app.herokuapp.com/",maxAge = 3600)
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{userId}")
    public List<Task> getList(@PathVariable String userId) {
        return taskService.getList(userId);
    }

    @PostMapping("/create")
    public Task create(@Validated @RequestBody Task task) {
        return taskService.create(task);
     }

    @PostMapping("/update") public Task update(@Validated @RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public boolean delete(@PathVariable String userId, @PathVariable String taskId) {
        return taskService.delete(userId,taskId);
    }
}
