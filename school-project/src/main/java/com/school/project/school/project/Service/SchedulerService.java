package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.models.User;
import com.school.project.school.project.models.dto.SchedulerInsertRequest;
import com.school.project.school.project.models.dto.SchedulerUpdateRequest;
import com.school.project.school.project.repository.CourseRepository;
import com.school.project.school.project.repository.SchedulerRepository;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public List<Scheduler> getSchedule() {
        return schedulerRepository.findAll();
    }

    public Scheduler getById(Integer id) {
        return schedulerRepository.findById(id).orElse(null);
    }

    public void add(SchedulerInsertRequest dto) {

        boolean overlappingScheduler = schedulerRepository.findByStartDateOrEndDate(dto.startDate, dto.endDate).isPresent();
        if(overlappingScheduler){
            throw new IllegalStateException("scheduler incepand la aceasta ora deja exista");
        }

        boolean existingUserAtCourse = schedulerRepository.findByUserIdAndCourseId(dto.userId, dto.courseId).isPresent();
        if(existingUserAtCourse){
            throw new IllegalStateException("user deja in curs");
        }

        User dbUser = userRepository.findUserById(dto.userId).get();
        Course dbCourse = courseRepository.findById(dto.courseId).get();

        schedulerRepository.save(new Scheduler(dto.startDate, dto.endDate, dbUser, dbCourse));
    }


    public void delete(Integer schedulerId) {
        schedulerRepository.findById(schedulerId);
        boolean exists = schedulerRepository.existsById(schedulerId);
        if (!exists) {
            throw new IllegalStateException("scheduler with id" + schedulerId + " does not exist");
        }
    }

    @Transactional
    public void update(Integer schedulerId, SchedulerUpdateRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(() -> new IllegalStateException("scheduler with id" + schedulerId + "does not exist"));
       }

}

