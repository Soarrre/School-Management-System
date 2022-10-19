package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.models.SchoolRole;
import com.school.project.school.project.models.User;
import com.school.project.school.project.models.dto.CourseInsertRequest;
import com.school.project.school.project.models.dto.SchedulerInsertRequest;
import com.school.project.school.project.repository.CourseRepository;
import com.school.project.school.project.repository.SchedulerRepository;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulerService {
    private final SchedulerRepository schedulerRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public SchedulerService(SchedulerRepository schedulerRepository, CourseRepository courseRepository) {
        this.schedulerRepository = schedulerRepository;
        this.courseRepository = courseRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Scheduler getById(Integer id) {
        return schedulerRepository.findSchedulerById(id).orElse(null);
    }

    public void add(SchedulerInsertRequest dto) {
        Scheduler dbScheduler = schedulerRepository.findById(dto.schedulerId).orElseThrow(() -> new IllegalStateException(("nu exista acest curs")));

        Optional<Scheduler> schedulerBystartTime = schedulerRepository.findSchedulerBystartTime(dto.startTime);
        if (schedulerBystartTime.isPresent()) {
            throw new IllegalStateException("scheduler incepand la aceasta ora deja exista");
        }
        Optional<Scheduler> schedulerByendTime = schedulerRepository.findSchedulerByendTime(dto.endTime);
        if (schedulerByendTime.isPresent()) {
            throw new IllegalStateException("scheduler sfarsind la aceasta ora deja exista");

            schedulerRepository.save(new  Scheduler(dto.startTime, dto.endTime, dbScheduler));


    }

}
}
