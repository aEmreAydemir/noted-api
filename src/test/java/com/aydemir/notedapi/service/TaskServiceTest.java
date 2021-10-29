package com.aydemir.notedapi.service;

import com.aydemir.notedapi.dto.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TaskServiceTest")
public class TaskServiceTest {
    @Mock
    TaskService taskService;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("create task should create task")
    void createTaskServiceTest() {
        Task task = new Task();
        task.setId("1");
        task.setChecked(false);
        task.setDescription("description");
        task.setUserId("1");
        Mockito.when(taskService.create(task)).thenReturn(task);
        Task testTask = taskService.create(task);
        assertEquals(testTask,task);
    }
}
