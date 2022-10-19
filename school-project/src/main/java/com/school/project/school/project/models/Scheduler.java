package com.school.project.school.project.models;

import javax.persistence.*;
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
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Scheduler() {
        this.id = 1;
        this.startDate = new Date();
        this.endDate = new Date();
    }

    public Scheduler(Date startDate, Date endDate, User user, Course course) {
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

    public Date getstartDate() {
        return startDate;
    }

    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getendDate() {
        return endDate;
    }

    public void setendDate(Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
