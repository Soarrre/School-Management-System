package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.SchoolRole;
import com.school.project.school.project.models.User;
import com.school.project.school.project.models.dto.CourseInsertRequest;
import com.school.project.school.project.models.dto.CourseUpdateRequest;
import com.school.project.school.project.repository.CourseRepository;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;


    @Autowired
    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository.findCourseById(id).orElse(null);
    }
    public void add(CourseInsertRequest dto) {
        User dbUser = userRepository.findById(dto.userId).orElseThrow(() -> new IllegalStateException(("nu exista acest user")));
        if(dbUser.getRole() != SchoolRole.Teacher){
            throw new IllegalStateException("doar profii pot avea un curs");
        }
        Optional<Course> courseByName = courseRepository.findCourseByName(dto.name);
        if (courseByName.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        courseRepository.save(new Course(dto.name, dbUser));
    }

    public void delete(Integer courseId) {
        courseRepository.findById(courseId);
        boolean exists = courseRepository.existsById(courseId);
        if (!exists) {
            throw new IllegalStateException("course with id" + courseId + " does not exist");
        }
        courseRepository.deleteById(courseId);
    }
    @Transactional
    public void update(Integer courseId, CourseUpdateRequest request) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("course with id" + courseId + "does not exist"));
        if (request.name != null && request.name.length() > 0 && !Objects.equals(course.getName(), request.name)) {
            course.setName(request.name);
        }
        if (request.name != null && request.name.length() > 0 && !Objects.equals(course.getName(), request.name)) {
            Optional<Course> existingCourse = courseRepository.findCourseByName(request.name);
            if(existingCourse.isPresent()){
                throw new IllegalStateException("course already exists");
            }
            else{
                course.setName(request.name);
            }
        }
        if(request.userId != null){
            User dbUser = userRepository.findById(request.userId).orElseThrow(() -> new IllegalStateException(("nu exista acest user")));
            if(dbUser.getRole() != SchoolRole.Teacher){
                throw new IllegalStateException("doar profii pot avea un curs");
            }
            course.setUser(dbUser);
        }
        courseRepository.save(course);

    }
















}
