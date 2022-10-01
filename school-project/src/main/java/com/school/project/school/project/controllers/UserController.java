package com.school.project.school.project.controllers;

import com.school.project.school.project.Service.UserService;
import com.school.project.school.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public User getUser(Integer userId) {
        return new User();
    }
    public List<User> getUsers() {
        return userService.getUsers();
    }

@PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }
@PutMapping(path ="{userId}")
    public void updateUser(@PathVariable("userId") Integer userId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email)
{

    userService.updateUser(userId, name, email);
}

}
