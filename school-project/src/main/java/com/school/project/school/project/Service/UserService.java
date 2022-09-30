package com.school.project.school.project.Service;


import com.school.project.school.project.models.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers(){
        return List.of (new User());
    }
}
