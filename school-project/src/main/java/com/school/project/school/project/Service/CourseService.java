package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;


    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository.findCourseById(id).orElse(null);
    }
    public void add(Course course) {
        Optional<Course> courseByName = courseRepository.findCourseByName(course.getName());
        if (courseByName.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        courseRepository.save(course);

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
    public void update(Integer courseId, String name) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("course with id" + courseId + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(course.getName(), name)) {
            course.setName(name);
        }
        if (name != null && name.length() > 0 && !Objects.equals(course.getName(), name)) {
            Optional<Course> existingCourse = courseRepository.findCourseByName(name);
            if(existingCourse.isPresent()){
                throw new IllegalStateException("course already exists");
            }
            else{
                course.setName(name);
            }
        }
        courseRepository.save(course);

    }
















}
