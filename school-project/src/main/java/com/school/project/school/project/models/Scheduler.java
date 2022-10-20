package com.school.project.school.project.models;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Scheduler {

    @Id
    @SequenceGenerator(
            name = "scheduler_sequence",
            sequenceName = "scheduler_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "scheduler_sequence"
    )

    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Scheduler() {
        this.id = 1;
        this.startDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
    }

    public Scheduler(LocalDateTime startDate, LocalDateTime endDate, User user, Course course) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getstartDate() {
        return startDate;
    }

    public void setstartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getendDate() {
        return endDate;
    }

    public void setendDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

}
