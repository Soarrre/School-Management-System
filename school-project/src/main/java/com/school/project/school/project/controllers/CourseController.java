package com.school.project.school.project.controllers;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.dto.CourseInsertRequest;
import com.school.project.school.project.models.dto.CourseUpdateRequest;
import com.school.project.school.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = {"application/json"})
    public Course getCourse(Integer courseId) {
        return courseService.getById(courseId);
    }

    @PostMapping(produces = {"application/json"})
    public boolean registerNewCourse(@RequestBody CourseInsertRequest dto) {
        courseService.add(dto);
        return true;
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer courseId) {
        courseService.delete(courseId);
    }

    @PutMapping(path = "{courseId}")
    public void updateCourse(@PathVariable("courseId") Integer courseId, @RequestBody CourseUpdateRequest request) {
        courseService.update(courseId, request);
    }
}
