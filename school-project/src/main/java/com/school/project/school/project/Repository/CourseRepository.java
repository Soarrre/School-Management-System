package com.school.project.school.project.Repository;

import com.school.project.school.project.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository  extends JpaRepository<Course,  Long> {
    void deleteById();
}









