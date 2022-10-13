package com.school.project.school.project.repository;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findCourseByName(String name);
    Optional<Course> findCourseById(Integer id);
    Optional<Course> findUserById(Integer id);


}
