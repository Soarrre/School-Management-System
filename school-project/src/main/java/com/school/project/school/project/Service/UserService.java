package com.school.project.school.project.service;


import com.school.project.school.project.models.dto.UserUpdateRequest;
import com.school.project.school.project.repository.UserRepository;
import com.school.project.school.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findUserById(id).orElse(null);
    }

    public void add(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
        System.out.println(user);
    }

    public void delete(Integer userId) {
        userRepository.findById(userId);
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id" + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void update(Integer userId, UserUpdateRequest userUpdateDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("student with id" + userId + "does not exist"));
        if (userUpdateDto.name != null && userUpdateDto.name.length() > 0 && !Objects.equals(user.getName(), userUpdateDto.name)) {
            user.setName(userUpdateDto.name);
        }
        if (userUpdateDto.email != null && userUpdateDto.email.length() > 0 && !Objects.equals(user.getEmail(), userUpdateDto.email)) {
            Optional<User> existingUser = userRepository.findUserByEmail(userUpdateDto.email);
            if(existingUser.isPresent()){
                throw new IllegalStateException("exista acest email in sistem");
            }
            else{
                user.setEmail(userUpdateDto.email);
            }
        }

        user.setRole(userUpdateDto.role);
        userRepository.save(user);

    }
}
