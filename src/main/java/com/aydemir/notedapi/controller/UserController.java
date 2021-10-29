package com.aydemir.notedapi.controller;

import com.aydemir.notedapi.model.UserInfo;
import com.aydemir.notedapi.dto.User;
import com.aydemir.notedapi.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
//@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@CrossOrigin(origins = "https://noted-web-app.herokuapp.com/",maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void create(@Validated @RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/auth")
    public UserInfo authenticate(@RequestParam @Validated @NotNull String email, @RequestParam @Validated @NotNull String password) throws Exception {
        return userService.authenticate(email,password);
    }
}
