package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.models.dto.SchedulerInsertRequest;
import com.school.project.school.project.repository.CourseRepository;
import com.school.project.school.project.repository.SchedulerRepository;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulerService {
    private final SchedulerRepository schedulerRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public SchedulerService(SchedulerRepository schedulerRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.schedulerRepository = schedulerRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Scheduler getById(Integer id) {
        return schedulerRepository.findById(id).orElse(null);
    }

    public void add(SchedulerInsertRequest dto) {
        Scheduler dbScheduler = schedulerRepository.findById(dto.schedulerId).get();

        if(dbScheduler != null){
            throw new IllegalStateException(("nu exista acest curs"));
        }

        Scheduler overlappingScheduler = schedulerRepository.findByInterval(dto.startDate, dto.endDate);

        if (overlappingScheduler != null) {
            throw new IllegalStateException("scheduler incepand la aceasta ora deja exista");
        }
        //ia user, ia curs -> insert in db
    }
}
