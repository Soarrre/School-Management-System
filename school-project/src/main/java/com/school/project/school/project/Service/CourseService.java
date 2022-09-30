package com.school.project.school.project.Service;

import com.school.project.school.project.Domain.Course;
import com.school.project.school.project.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<Course> listAll(){
        return repository.findAll();
    }
     public void save(Course course){
         repository.save(course);
     }
     public Course get(long id){
        return repository.findById(id).get();
     }
     public void delete(long id){
         repository.deleteById();
     }





}


