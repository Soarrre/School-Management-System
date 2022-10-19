package com.school.project.school.project.repository;

import com.school.project.school.project.models.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {
    @Query("SELECT s FROM Scheduler s WHERE s.startDate = ?1")
    Scheduler findByInterval(Date startDate, Date endDate);
}
