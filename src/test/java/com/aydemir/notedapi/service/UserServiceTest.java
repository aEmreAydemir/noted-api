package com.aydemir.notedapi.service;

import com.aydemir.notedapi.model.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("UserServiceTest")
public class UserServiceTest {
    @Mock

    UserService userService;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("auth users with email and password should return user info")
    void authUser() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("5");
        userInfo.setEmail("dummy@gmail.com");
        userInfo.setName("dummy");
        userInfo.setToken("token");
        Mockito.when(userService.authenticate("emre@gmail.com","pass")).thenReturn(userInfo);
        UserInfo test = userService.authenticate("emre@gmail.com","pass");
        assertEquals(test,userInfo);
    }
}
