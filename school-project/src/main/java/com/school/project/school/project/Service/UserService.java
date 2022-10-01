package com.school.project.school.project.Service;


import com.school.project.school.project.Repository.UserRepository;
import com.school.project.school.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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


    public void deleteUser(Integer userId) {
    userRepository.findById(userId);
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id" + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Integer userId, String name, String email){
    User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
            "student with id" + userId + "does not exist")
    );
        if (name != null &&
            name.length() > 0 &&
                !Objects.equals(user.getName(), name)){
        user.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
        }

        user.setEmail(email);


    }




}
