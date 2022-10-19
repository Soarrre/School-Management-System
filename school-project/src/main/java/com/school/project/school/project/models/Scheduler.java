package com.school.project.school.project.models;

import javax.persistence.*;

@Entity
@Table
public class Scheduler {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )

    private Integer id;
    private String startTime;
    private String endTime;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne
    @JoinColumn(name = "scheduler_id")
    private Scheduler scheduler;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Scheduler(){
        this.id = 1;
        this.startTime = ora;
        this.endTime = ora;
    }
    public Scheduler(String startTime , String endTime , Scheduler course) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
                "id=" + id +
                ", startTime='" + scheduler.getStartTime() + '\'' +
                ", endTime='" + scheduler.getEndTime() + '\'' +
                '}';
    }

}
