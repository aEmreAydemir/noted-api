package com.aydemir.notedapi.controller;

import com.aydemir.notedapi.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("TaskControllerTest")
@EnableWebMvc
@SpringBootTest(classes = TaskController.class)
public class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    TaskService taskService;

    @Test
    @DisplayName("post request to api/task/create should return successful http status")
    void taskCreateTest() throws Exception {
        mockMvc.perform(post("/api/task/create")
                .contentType("application/json")
                .content("{\"userId\":1,\"description\":\"test\",\"checked\":false}"))
                .andExpect(status().is2xxSuccessful()).andReturn();
    }

    @Test
    @DisplayName("get request to api/task/1 should return successful http status")
    void getTasksTest() throws Exception {
        mockMvc.perform(get("/api/task/1")
                        .contentType("application/json"))
                .andExpect(status().is2xxSuccessful()).andReturn();
    }

    @Test
    @DisplayName("post request to api/task/update should return successful http status")
    void updateTaskTest() throws Exception {
        mockMvc.perform(post("/api/task/update")
                        .contentType("application/json")
                        .content("{\"userId\":1,\"description\":\"test\",\"checked\":false}"))
                .andExpect(status().is2xxSuccessful()).andReturn();
    }

    @Test
    @DisplayName("delete request to api/task/1/1 should return successful http status")
    void deleteTaskTest() throws Exception {
        mockMvc.perform(delete("/api/task/1/1")
                        .contentType("application/json"))
                .andExpect(status().is2xxSuccessful()).andReturn();
    }
}
