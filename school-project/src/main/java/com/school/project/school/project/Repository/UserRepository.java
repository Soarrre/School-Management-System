package com.school.project.school.project.Repository;

import com.school.project.school.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // SELECT * FROM user WHERE email = ?
    Optional<User> findUserByEmail(String email);

}
