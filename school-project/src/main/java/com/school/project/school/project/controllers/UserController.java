package com.school.project.school.project.controllers;

import com.school.project.school.project.service.UserService;
import com.school.project.school.project.models.User;
import com.school.project.school.project.models.dto.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = { "application/json" })
    public User getUser(Integer userId) {
        return userService.getById(userId);
    }

    @PostMapping(produces = { "application/json" })
    public boolean registerNewUser(@RequestBody User user) {
        userService.add(user);
        return true;
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserUpdateRequest request) {
        userService.update(userId, request.name, request.email);
    }

}
