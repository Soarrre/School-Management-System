package com.school.project.school.project.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;


//Constructors

    public Course() {


    }

    public Course(int duration) {
        this.duration = duration;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(Long id) {
        this.id = id;
    }

    //Getters

    public int getDuration() {
        return duration;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

//Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
