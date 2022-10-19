package com.school.project.school.project.repository;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {
   Optional<Scheduler> findSchedulerById(Integer id);
   Optional<Scheduler> findSchedulerByendTime(String endTime);
   Optional<Scheduler> findSchedulerBystartTime(String startTime);
   Optional<Course> findCourseById(Integer id);
}
