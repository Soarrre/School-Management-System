package com.school.project.school.project.repository;

import com.school.project.school.project.models.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {

    Optional<Scheduler> findByStartDateOrEndDate(LocalDateTime startDate, LocalDateTime endDate);
    Optional<Scheduler> findByUserIdAndCourseId(Integer userId, Integer courseId);
}
