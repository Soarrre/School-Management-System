package com.school.project.school.project.Service;


import com.school.project.school.project.Repository.UserRepository;
import com.school.project.school.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


@Autowired
    public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
}
    public List<User> getUsers(){
       return userRepository.findAll();
    }
    public void addNewUser(User user){
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
        System.out.println(user);
    }







}
