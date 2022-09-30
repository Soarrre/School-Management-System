package com.school.project.school.project.controllers;

import com.school.project.school.project.Service.UserService;
import com.school.project.school.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {


    private final UserService userService;
    @Autowired

    public UserController (UserService userService){
        this.userService = new UserService();
    }

    @GetMapping
    public User getUser(Integer userId) {
        return new User();
    }
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
