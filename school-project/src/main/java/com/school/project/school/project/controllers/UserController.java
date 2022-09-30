package com.school.project.school.project.controllers;

import com.school.project.school.project.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping(produces = { "application/json" })
    public User getUser(Integer userId) {
        return new User();
    }
}